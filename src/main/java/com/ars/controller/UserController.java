package com.ars.controller;

import com.ars.dto.UserDTO;
import com.ars.exceptions.ApiException;
import com.ars.exceptions.ApiResponse;
import com.ars.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserDTO>> getUser(@PathVariable int userId) {
        UserDTO getUser = userService.getUserById(userId);
        return ResponseEntity.ok(new ApiResponse<>(true, getUser, null));
    }
    @PostMapping
    public ResponseEntity<ApiResponse<UserDTO>> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createUser = userService.saveUser(userDTO);
        return ResponseEntity.ok(new ApiResponse<>(true, createUser, null));
    }

    @PostMapping("/addMultiple")
    public ResponseEntity<ApiResponse<List<UserDTO>>> addUsers(@RequestBody List<UserDTO> userDTOList) {
        List<UserDTO> addUsers = userService.addMultipleUsers(userDTOList);
        return ResponseEntity.ok(new ApiResponse<>(true, addUsers, null));
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<String> handleUserNotFoundException(ApiException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message: " + ex.getMessage());
    }
    @GetMapping
    public ResponseEntity<ApiResponse<List<UserDTO>>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(new ApiResponse<>(true, users, null));
    }
    @PutMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserDTO>> updateUser(@PathVariable int userId, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(userId,userDTO);
        if(updatedUser == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse<>(false, null, "User not found"));
        }
        return ResponseEntity.ok(new ApiResponse<>(true, updatedUser, null));
    }
}