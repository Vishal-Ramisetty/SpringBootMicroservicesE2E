package com.lcwd.rating.service.impl;

import com.lcwd.rating.exception.RatingNotFound;
import com.lcwd.rating.entity.Ratings;
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
        return ratingRepository.findRatingsByUserId(hotelId);
    }
}
