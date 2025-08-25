package com.lcwd.rating.controller;

import com.lcwd.rating.entity.Ratings;
import com.lcwd.rating.service.impl.RatingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    private RatingServiceImpl ratingService;

    @Autowired
    public void RestController(RatingServiceImpl ratingService){
        this.ratingService = ratingService;
    }

    @PostMapping
    private ResponseEntity<Ratings> createNewRating(@RequestBody Ratings ratings){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(ratings));
    }

    @GetMapping
    private ResponseEntity<List<Ratings>> getAllRatings(){
        return ResponseEntity.ok().body(ratingService.findAllRatings());
    }

    @GetMapping("/{ratingId}")
    private ResponseEntity<Ratings> getRatingById(@PathVariable String ratingId){
        return ResponseEntity.ok().body(ratingService.findRatingById(ratingId));
    }

    @GetMapping("/user/{userId}")
    private ResponseEntity<List<Ratings>> getRatingsByUserId(@PathVariable String userId){
        return ResponseEntity.ok().body(ratingService.findRatingsByUserId(userId));
    }

    @GetMapping("/hotel/{hotelId}")
    private ResponseEntity<List<Ratings>> getRatingsByHotelId(@PathVariable String hotelId){
        return ResponseEntity.ok().body(ratingService.findRatingsByHotelId(hotelId));
    }

}
