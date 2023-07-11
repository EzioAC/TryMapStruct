package com.xgh.trymapstruct.mapstruct.mapper;

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
    @Mapping(source = "carType", target = "type")
    @Mapping(source = "make",target = "make",defaultValue = "Wood")
    @Mapping(source = "createDate",target = "createDate",dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(source = "updateDate",target = "updateDate",dateFormat = "yyyy-MM-dd HH:mm:ss")
    CarDto carToCarDto(Car car);

    @Mapping(source = "seatCount", target = "numberOfSeats")
    @Mapping(source = "type", target = "carType")
    @Mapping(source = "createDate",target = "createDate",dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Mapping(target = "updateDate",expression = "java(new java.util.Date())")
    Car carDtoToCar(CarDto carDto);

    Car deepCopy(Car car);
}