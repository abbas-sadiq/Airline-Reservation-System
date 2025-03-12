package com.ars.controller;

import com.ars.dto.UserDTO;
import com.ars.exceptions.ApiException;
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
    public ResponseEntity<UserDTO> getUser(@PathVariable int userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.saveUser(userDTO));
    }

    @PostMapping("/addMultiple")
    public ResponseEntity<List<UserDTO>> addUsers(@RequestBody List<UserDTO> userDTOList) {
        return ResponseEntity.ok(userService.addMultipleUsers(userDTOList));
    }

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<String> handleUserNotFoundException(ApiException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Message: " + ex.getMessage());
    }
    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }
    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable int userId, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(userId,userDTO));
    }
}