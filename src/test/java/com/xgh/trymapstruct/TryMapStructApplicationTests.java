package com.xgh.trymapstruct;

import com.alibaba.fastjson.JSON;
import com.xgh.trymapstruct.mapstruct.enums.CarTypeEnum;
import com.xgh.trymapstruct.mapstruct.mapper.CarMapper;
import com.xgh.trymapstruct.mapstruct.pojo.Car;
import com.xgh.trymapstruct.mapstruct.pojo.CarDto;
import com.xgh.trymapstruct.mapstruct.pojo.Wheel;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class TryMapStructApplicationTests {

    @Test
    void contextLoads() {

    }

    @AfterEach
    void printSplitter() {
        System.out.println("=============================");
    }

    /**
     * 类型转换Demo
     */
    @Test
    void testConvert() {

        Car car = new Car("Morris", 5, Lists.newArrayList(new Wheel("马牌")), CarTypeEnum.F1,new Date(),new Date());

        CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);

        Assertions.assertNotNull(carDto);
        Assertions.assertEquals(carDto.getMake(), "Morris");
        System.out.println("Car");
        System.out.println(JSON.toJSONString(car));
        System.out.println("carDto");
        System.out.println(JSON.toJSONString(carDto));
    }

    /**
     * 深拷贝
     * List<Wheel>也可以深拷贝
     */
    @Test
    void testDeepCopy() {

        Car car = new Car("Morris", 5, Lists.newArrayList(new Wheel("马牌")),CarTypeEnum.F1,new Date(),new Date());

        Car car2 = CarMapper.INSTANCE.deepCopy(car);

        Assertions.assertNotSame(car, car2);
        Assertions.assertEquals(car,car2);
        Assertions.assertEquals(car.getMake(), car2.getMake());
        Assertions.assertEquals(car.getNumberOfSeats(),car2.getNumberOfSeats());
        //Wheel也为深拷贝
        Assertions.assertNotSame(car.getWheelList().get(0), car2.getWheelList().get(0));
        Assertions.assertEquals(JSON.toJSONString(car),JSON.toJSONString(car2));

        System.out.println("Car");
        System.out.println(JSON.toJSONString(car));
        System.out.println("Car2");
        System.out.println(JSON.toJSONString(car2));
    }

    @Test
    void testPropertiesTypeConvert() {

    }

    /**
     * 枚举类型自动转换
     * xxxEnum.name() <-> String
     */
    @Test
    void testEnumConvert() {
        Car car = new Car("Morris", 5, Lists.newArrayList(new Wheel("马牌")), CarTypeEnum.F1,new Date(),new Date());

        CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);

        Assertions.assertNotNull(carDto);
        Assertions.assertEquals(carDto.getType(), car.getCarType().name());
        System.out.println("Car");
        System.out.println(JSON.toJSONString(car));
        System.out.println("carDto");
        System.out.println(JSON.toJSONString(carDto));
    }

    /**
     * 空值情况去默认值
     * defaultValue
     * defaultExpression
     */
    @Test
    void testDefault() {
        Car car = new Car(null, 5, Lists.newArrayList(new Wheel("马牌")),CarTypeEnum.F1,new Date(),new Date());
        CarDto carDto = CarMapper.INSTANCE.carToCarDto(car);

        Assertions.assertEquals(carDto.getMake(),"Wood");
        System.out.println("Car");
        System.out.println(JSON.toJSONString(car));
        System.out.println("carDto");
        System.out.println(JSON.toJSONString(carDto));
    }

    /**
     * 日期Str转Date类型
     * createDate str转Date
     * updateDate取当前时间 expression  java()
     */
    @Test
    void testStrToDate() {
        CarDto carDto = new CarDto(null, 5,"F1", Lists.newArrayList(new Wheel("马牌")),"2023-07-12 00:00:53","2023-07-12 00:06:53");

        Car car = CarMapper.INSTANCE.carDtoToCar(carDto);

        System.out.println("Car");
        System.out.println(JSON.toJSONString(car));
        System.out.println("carDto");
        System.out.println(JSON.toJSONString(carDto));
    }

    @Test
    void testCustomizeConvert() {

    }

}
