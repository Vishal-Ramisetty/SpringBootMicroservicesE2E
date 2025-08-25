package com.lcwd.hotel.service.impl;

import com.lcwd.hotel.exception.HotelNotFoundException;
import com.lcwd.hotel.model.Hotels;
import com.lcwd.hotel.repository.HotelRepository;
import com.lcwd.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotels saveHotel(Hotels hotel) {
        hotel.setId(java.util.UUID.randomUUID().toString());
        return hotelRepository.save(hotel);
    }

    @Override
    public Hotels getHotelById(String id) {
        return hotelRepository.findById(id).
                orElseThrow
                        (() -> new HotelNotFoundException("Hotel with given id not found on server !! : " + id));
    }

    @Override
    public List<Hotels> getAllHotels() {
        List<Hotels>  hotels= hotelRepository.findAll();
        if(hotels.size()==0){
            throw new HotelNotFoundException("No Hotels found in database");
        }
        return hotels;
    }
}
