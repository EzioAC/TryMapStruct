package com.xgh.trymapstruct;

import com.alibaba.fastjson.JSON;
import com.xgh.trymapstruct.mapstruct.CarMapper;
import com.xgh.trymapstruct.mapstruct.pojo.Car;
import com.xgh.trymapstruct.mapstruct.pojo.CarDto;
import com.xgh.trymapstruct.mapstruct.pojo.Wheel;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

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

        Car car = new Car("Morris", 5, Lists.newArrayList(new Wheel("马牌")));

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

        Car car = new Car("Morris", 5, Lists.newArrayList(new Wheel("马牌")));

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

}
