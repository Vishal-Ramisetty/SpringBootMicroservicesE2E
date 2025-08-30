package com.lcwd.rating.service.impl;

import com.lcwd.rating.entity.Users;
import com.lcwd.rating.exception.RatingNotFound;
import com.lcwd.rating.entity.Ratings;
import com.lcwd.rating.external.services.UserService;
import com.lcwd.rating.repository.RatingRepository;
import com.lcwd.rating.service.RatingServive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RatingServiceImpl implements RatingServive {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserService userService;

    @Autowired
    public RatingServiceImpl(RatingRepository ratingRepository){
        this.ratingRepository = ratingRepository;
    }


    @Override
    public Ratings createRating(Ratings rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public Ratings findRatingById(String id) {
        return ratingRepository.findById(id)
                .orElseThrow(()-> new RatingNotFound("Rating with given id is not found on server !! : "+id));
    }

    @Override
    public List<Ratings> findAllRatings() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Ratings> findRatingsByUserId(String userId) {
        return ratingRepository.findRatingsByUserId(userId);
    }

    @Override
    public List<Ratings> findRatingsByHotelId(String hotelId) {
        return ratingRepository.findRatingsByHotelId(hotelId);
    }


    public Users findUserInfoWithRatings(String userId, String hotelId) {
        Ratings ratingsForUser= ratingRepository.findRatingsByHotelIdAndUserId(hotelId,userId);
        log.info("Ratings : {}", ratingsForUser);
        Users user= userService.findUserById(userId);
        log.info("User Info for Ratings: {}", user);
        user.setRatings(ratingsForUser);
        return user;
    }

    public Users updateUserInfoWithRatings(String userId, String hotelId, Users user) {
        Ratings ratingsForUser= ratingRepository.findRatingsByHotelIdAndUserId(hotelId,userId);
        log.info("Ratings : {}", ratingsForUser);
        log.info("Old User Info for Ratings: {}", user);
        Users updatedUser= userService.updateUser(userId,user);
        updatedUser.setRatings(ratingsForUser);
        log.info("Updated user Info for Ratings: {}", updatedUser);
        return updatedUser;
    }
}
