package com.xgh.trymapstruct.mapstruct;

import com.xgh.trymapstruct.mapstruct.pojo.Car;
import com.xgh.trymapstruct.mapstruct.pojo.CarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//会采取WheelMapper实现的深拷贝和数组深拷贝
@Mapper(uses = WheelMapper.class)
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper( CarMapper.class );

    //两对象字段名称不同
    @Mapping(source = "numberOfSeats", target = "seatCount")
    CarDto carToCarDto(Car car);

    Car deepCopy(Car car);
}