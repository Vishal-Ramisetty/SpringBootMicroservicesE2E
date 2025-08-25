package com.lcwd.hotel.service;


import com.lcwd.hotel.model.Hotels;

import java.util.List;

public interface HotelService {

    Hotels saveHotel(Hotels hotel);

    Hotels getHotelById(String id);

    List<Hotels> getAllHotels();


}
