package com.xgh.trymapstruct.mapstruct.mapper;

import com.xgh.trymapstruct.mapstruct.pojo.Wheel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface WheelMapper {

    //深拷贝
    Wheel deepCopy(Wheel wheel);

    //数组深拷贝
    List<Wheel> deepCopyList(List<Wheel> wheelList);
}
