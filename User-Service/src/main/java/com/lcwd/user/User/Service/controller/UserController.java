package com.lcwd.user.User.Service.controller;

import com.lcwd.user.User.Service.entity.Users;
import com.lcwd.user.User.Service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
//@Tag(name="Users",description = "User Management APIs")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String welcome() {
        return "Welcome to User Service";
    }

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users user) {
        Users myuser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }


    @GetMapping
    public ResponseEntity<List<Users>> findAllUsers() {
        List<Users> users = userService.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Users> findUserById(@PathVariable(name = "") String userId) {
        Users user = userService.findUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PutMapping
    public ResponseEntity<Users> updateUser(@RequestBody Users user) {
        Users updatedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Users> deleteUserById(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
