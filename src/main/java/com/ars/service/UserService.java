package com.ars.service;

import com.ars.dto.UserDTO;

public interface UserService {
    UserDTO getUserById(int userId);
    UserDTO saveUser(UserDTO userDTO);
}