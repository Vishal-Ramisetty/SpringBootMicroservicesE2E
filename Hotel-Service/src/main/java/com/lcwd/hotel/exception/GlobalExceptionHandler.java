package com.lcwd.hotel.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleHotelNotFoundException(HotelNotFoundException ex){
        log.error(ex.getStackTrace().toString());
        ExceptionResponse response = ExceptionResponse.builder()
                .message(ex.getMessage())
                .statusCode(HttpStatus.NOT_FOUND)
                .timeStamp(System.currentTimeMillis())
                .status(false)
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleException(Exception ex){
        log.warn(ex.getStackTrace().toString());
        ExceptionResponse response = ExceptionResponse.builder()
                .message(ex.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST)
                .timeStamp(System.currentTimeMillis())
                .status(false)
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

}
