package com.lcwd.user.User.Service.service.impl;

import com.lcwd.user.User.Service.entity.Ratings;
import com.lcwd.user.User.Service.entity.Users;
import com.lcwd.user.User.Service.exception.ResourceNotFoundException;
import com.lcwd.user.User.Service.repository.UserRepository;
import com.lcwd.user.User.Service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

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

    public Users findUserWithRatings(String userId){
        Users user=findUserById(userId);
        //fetch ratings of the above user from RATING SERVICE
        Ratings[] ratings= restTemplate
                .getForObject("http://localhost:8083/api/ratings/user/"+userId,Ratings[].class);
        logger.info(" The ratings for user Id {} is {}", userId, ratings);
        // Update User entity with ratings

        user.setRatings(List.of(ratings));
        userRepository.save(user);
        return user;
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
