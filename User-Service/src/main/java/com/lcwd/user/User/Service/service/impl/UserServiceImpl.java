package com.lcwd.user.User.Service.service.impl;

import com.lcwd.user.User.Service.entity.Users;
import com.lcwd.user.User.Service.exception.ResourceNotFoundException;
import com.lcwd.user.User.Service.repository.UserRepository;
import com.lcwd.user.User.Service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users saveUser(Users user) {
//        user.setId(UUID.randomUUID());
        return userRepository.save(user);
    }

    @Override
    public List<Users> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users findUserById(String id) {
        return userRepository.findById(UUID.fromString(id))
                .orElseThrow(()->new ResourceNotFoundException("User with given id not found on server !! : " + id));
    }

    @Override
    public Users updateUser(String id, Users updatedUser) {
       Users user =findUserById(id);
       user.setName(updatedUser.getName());
       user.setEmail(updatedUser.getEmail());
       user.setAbout(updatedUser.getAbout());
       saveUser(user);
       return user;
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(UUID.fromString(id));
    }
}
