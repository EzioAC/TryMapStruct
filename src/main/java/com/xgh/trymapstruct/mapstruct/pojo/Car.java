package com.xgh.trymapstruct.mapstruct.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private String make;
    private int numberOfSeats;
    private List<Wheel> wheelList;


    //constructor, getters, setters etc.
}
