package com.lcwd.rating.entity;

import lombok.*;
import org.springframework.data.annotation.Transient;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Users {

    private UUID id;

    private String name;

    private String email;

    private String about;

    @Transient
    private Ratings ratings;

}

