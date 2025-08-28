package com.lcwd.user.User.Service.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotels {

    private UUID id;
    private String name;
    private String location;
    private String about;
}
