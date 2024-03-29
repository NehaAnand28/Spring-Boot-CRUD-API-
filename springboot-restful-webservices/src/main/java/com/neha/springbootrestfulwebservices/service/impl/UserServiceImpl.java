package com.neha.springbootrestfulwebservices.service.impl;

import com.neha.springbootrestfulwebservices.exception.ResourceNotFoundException;
import com.neha.springbootrestfulwebservices.model.User;
import com.neha.springbootrestfulwebservices.repository.UserRepository;
import com.neha.springbootrestfulwebservices.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
    return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
//        Optional<User> user = userRepository.findById(id);
//        if(user.isPresent()){
//            return user.get();
//        }else{
//            throw new ResourceNotFoundException("User","Id",id);
//        }
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","Id",id));
    }

    @Override
    public User updateUser(User user, long id) {
        //check whether user with given id exists in DB or not
        User existingUser =  userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","Id",id));

        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        //save existing user to DB
        userRepository.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUserById(long id) {
        //check whether user exists in DB or not
        userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User","Id",id));
        userRepository.deleteById(id);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }


}
