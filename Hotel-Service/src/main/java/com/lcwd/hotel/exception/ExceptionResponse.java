package com.lcwd.hotel.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ExceptionResponse {
    private String message;
    private long timeStamp;
    private HttpStatus statusCode;
    private boolean status;

}
