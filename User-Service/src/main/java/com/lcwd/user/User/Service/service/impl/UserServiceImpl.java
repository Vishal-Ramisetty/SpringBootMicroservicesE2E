package com.lcwd.user.User.Service.service.impl;

import com.lcwd.user.User.Service.entity.Hotels;
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

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
                .orElseThrow(() -> new ResourceNotFoundException("User with given id not found on server !! : " + id));
    }

    public Users findUserWithRatings(String userId) {
        Users user = findUserById(userId);
        //fetch ratings of the above user from RATING SERVICE
        Ratings[] ratings = restTemplate
                .getForObject("http://RATINGSERVICE/api/ratings/user/" + userId, Ratings[].class);
        logger.info(" The ratings for user Id {} is {}", userId, ratings);

       // Get Hotel info based on ratings for an user
        List<Ratings> UserWithHotelAndItsRatings = Arrays.stream(ratings).map(rating -> {
            // Get Hotel info based on ratingId
            Hotels h = restTemplate
                    .getForObject("http://HOTEL-SERVICE/api/hotels/"+ rating.getHotelId(), Hotels.class);
            rating.setHotel(h);
            return rating;
        }).toList();

        // Update User entity with ratings
        user.setRatings(UserWithHotelAndItsRatings);
        userRepository.save(user);
        return user;
    }

    @Override
    public Users updateUser(String id, Users updatedUser) {
        Users user = findUserById(id);
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
