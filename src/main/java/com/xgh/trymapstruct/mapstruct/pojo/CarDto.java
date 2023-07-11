package com.xgh.trymapstruct.mapstruct.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    private String make;
    private int seatCount;
    private String type;
    private List<Wheel> Wheels;
    private String createDate;
    private String updateDate;

    //constructor, getters, setters etc.
}