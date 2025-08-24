package com.lcwd.user.User.Service.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="users")
public class Users {

    @Id
    @Column(name="id")
    private UUID id;

    @Column(name="name", length=50)
    private String name;

    @Column(name="email")
    private String email;

    @Column(name = "about", length=250)
    private String about;

    @Transient
    private List<Ratings> ratings;

}
