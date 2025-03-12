package com.ars.service.impl;

import com.ars.dto.UserDTO;
import com.ars.exceptions.ApiException;
import com.ars.model.User;
import com.ars.mapper.UserMapper;
import com.ars.repository.UserRepository;
import com.ars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserById(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new ApiException("User not found ID: " + userId));
        return UserMapper.toDTO(user);
    }

    public UserDTO saveUser(UserDTO userDTO) {
        if(userRepository.existsByUsername(userDTO.getName())){
            throw  new ApiException("Username already exists!");
        }
        if(userRepository.existsByEmail(userDTO.getEmail())){
            throw  new ApiException("Email already exists!");
        }
        User user = UserMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return UserMapper.toDTO(user);
    }
    public List<UserDTO> addMultipleUsers(List<UserDTO> userDTOList) {
        if(userDTOList == null || userDTOList.isEmpty() || !StringUtils.hasText(userDTOList.getFirst().getName())){
            throw  new ApiException("invalid request");
        }
        if(userRepository.existsByUsername(userDTOList.get(0).getName())){
            throw new ApiException("Username already exists!");
        }
        List<User> users = userDTOList.stream()
                .map(UserMapper::toEntity)
                .collect(Collectors.toList());
        List<User> savedUsers = userRepository.saveAll(users);
        return savedUsers.stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }
    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        if(users.isEmpty()){
            throw  new ApiException("User not found");
        }
        return users.stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }

    public UserDTO updateUser(int userId, UserDTO userDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ApiException("User not found ID: " + userId));

        user.setUsername(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());

        user = userRepository.save(user);

        return UserMapper.toDTO(user);
    }

}