package com.lcwd.user.User.Service.exception;

import com.lcwd.user.User.Service.exception.payload.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        ExceptionResponse response= ExceptionResponse.builder()
                .message(ex.getMessage())
                .statusCode(HttpStatus.NOT_FOUND)
                .success(false)
                .timeStamp(LocalDateTime.now().toEpochSecond(java.time.ZoneOffset.UTC))
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }
}
