package com.ars.service.impl;

import com.ars.dto.UserDTO;
import com.ars.model.User;
import com.ars.mapper.UserMapper;
import com.ars.repository.UserRepository;
import com.ars.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserDTO getUserById(int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return UserMapper.toDTO(user);
    }

    public UserDTO saveUser(UserDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return UserMapper.toDTO(user);
    }
    public List<UserDTO> addMultipleUsers(List<UserDTO> userDTOList) {
        List<User> users = userDTOList.stream()
                .map(UserMapper::toEntity)
                .collect(Collectors.toList());
        List<User> savedUsers = userRepository.saveAll(users);
        return savedUsers.stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }
}