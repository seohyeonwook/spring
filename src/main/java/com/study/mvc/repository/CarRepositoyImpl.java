package com.study.mvc.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("a") //  @Service  Component랑 같다
public class CarRepositoyImpl implements CarRepository{// implements해줘야 빨간줄 없어짐

    @Override
    public List<String> getCarNames() {
        return List.of("아반뗴", "소나따");
    }

    @Override
    public int insertCar(String carName) {
        System.out.println("등록된 차량:" + carName);
        return 1;
    }
}
