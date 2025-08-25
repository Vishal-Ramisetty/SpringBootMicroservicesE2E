package com.lcwd.rating.exception;

import com.lcwd.rating.exception.Response.ExceptionResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(RatingNotFound.class)
    public ResponseEntity<ExceptionResponse> handleRatingNotFound(RatingNotFound ex){
        logger.error("Exception caught: {}", ex.getStackTrace().toString());
        ExceptionResponse response =
                ExceptionResponse.builder()
                        .message(ex.getMessage())
                        .status(HttpStatus.NOT_FOUND)
                        .timeStamp(System.currentTimeMillis())
                        .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleOtherException(Exception ex){
        logger.error("Exception caught in Global Exception Handler: {}", ex.getStackTrace().toString());
        ExceptionResponse response =
                ExceptionResponse.builder()
                        .message(ex.getMessage())
                        .status(HttpStatus.NOT_FOUND)
                        .timeStamp(System.currentTimeMillis())
                        .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
