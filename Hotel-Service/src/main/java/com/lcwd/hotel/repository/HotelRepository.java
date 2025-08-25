package com.lcwd.hotel.repository;

import com.lcwd.hotel.model.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotels,String> {

}
