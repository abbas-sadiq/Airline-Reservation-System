package com.ars.service;

import com.ars.dto.UserDTO;
import com.ars.exceptions.ApiResponse;

import java.util.List;

public interface UserService {
    UserDTO getUserById(int userId);
    UserDTO saveUser(UserDTO userDTO);
    List<UserDTO>addMultipleUsers(List<UserDTO> userDTOList);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(int userId, UserDTO userDTO);

}