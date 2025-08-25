package com.lcwd.rating.service;

import com.lcwd.rating.entity.Ratings;

import java.util.List;

public interface RatingServive {

    Ratings createRating(Ratings rating);

    Ratings findRatingById(String id);

    List<Ratings> findAllRatings();

    List<Ratings> findRatingsByUserId(String userId);

    List<Ratings> findRatingsByHotelId(String hotelId);
}
