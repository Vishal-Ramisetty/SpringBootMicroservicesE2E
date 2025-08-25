package com.lcwd.hotel.controller;

import com.lcwd.hotel.model.Hotels;
import com.lcwd.hotel.service.HotelService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hotels")
@Tag(name = "Hotel", description = "Hotel Management APIs")
public class HotelController {

    private HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping
    @Operation(summary = "Create Hotel")
    public ResponseEntity<Hotels> createHotel(@RequestBody Hotels hotel) {
        Hotels myhotel = hotelService.saveHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(myhotel);
    }

    @GetMapping
    @Operation(summary = "Get All Hotels")
    public ResponseEntity<List<Hotels>> getAllHotels() {
        List<Hotels> hotels = hotelService.getAllHotels();
        return ResponseEntity.status(HttpStatus.OK).body(hotels);
    }

    @GetMapping("/{hotelId}")
    @Operation(summary = "Get Hotel by ID")
    public ResponseEntity<Hotels> getHotelById(@PathVariable String hotelId) {
        Hotels myhotel = hotelService.getHotelById(hotelId);
        return ResponseEntity.status(HttpStatus.OK).body(myhotel);
    }
}
