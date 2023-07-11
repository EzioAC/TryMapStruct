package com.xgh.trymapstruct.mapstruct.pojo;


import com.xgh.trymapstruct.mapstruct.enums.CarTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    private String make;
    private int numberOfSeats;
    private List<Wheel> wheelList;
    private CarTypeEnum carType;
    private Date createDate;
    private Date updateDate;


    //constructor, getters, setters etc.
}
