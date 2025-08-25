package com.lcwd.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hotels")
public class Hotels {

    @Id
    private String id;
    @NotBlank(message = "Hotel name is mandatory")
    @Column(nullable = false, unique = true)
    private String name;
    private String address;
    private String about;


}
