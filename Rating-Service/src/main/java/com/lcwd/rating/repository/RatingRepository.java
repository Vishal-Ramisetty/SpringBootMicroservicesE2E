package com.lcwd.rating.repository;

import com.lcwd.rating.entity.Ratings;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Ratings, String> {

    List<Ratings> findRatingsByUserId(String userId);

    List<Ratings> findRatingsByHotelId(String hotelId);

    Ratings findRatingsByHotelIdAndUserId(String hotelId, String userId);
}
