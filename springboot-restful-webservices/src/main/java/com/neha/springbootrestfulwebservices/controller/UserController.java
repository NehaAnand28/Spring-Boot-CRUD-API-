package com.neha.springbootrestfulwebservices.controller;

import com.neha.springbootrestfulwebservices.model.User;
import com.neha.springbootrestfulwebservices.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    //build create User REST API
    @PostMapping()
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
    }

    //build get all users REST API
    @GetMapping()
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //build get user by ID
    //http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long userId){
        return new ResponseEntity<User>(userService.getUserById(userId),HttpStatus.OK);
    }

    //build update user REST API
    //http://localhost:8080/api/users/1
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") long id,@RequestBody User user){
        return new ResponseEntity<User>(userService.updateUser(user,id),HttpStatus.OK);
    }

    //build delete user by Id REST API
    //http://localhost:8080/api/users/1
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUserbyId(@PathVariable("id") long id){
        userService.deleteUserById(id);
        return new ResponseEntity<String>("User deleted Successfully !!",HttpStatus.OK);
    }

    //build delete user REST API
    //http://localhost:8080/api/users/
    @DeleteMapping()
    public ResponseEntity<String> deleteAllUsers(){
        userService.deleteAllUsers();
        return new ResponseEntity<String>("All Users deleted Successfully !!",HttpStatus.OK);
    }

}

