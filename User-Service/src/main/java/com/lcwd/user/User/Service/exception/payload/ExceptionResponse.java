package com.lcwd.user.User.Service.exception.payload;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExceptionResponse {

    private String message;
    private long timeStamp;
    private HttpStatus statusCode;
    private boolean success;


}
