package com.study.mvc.service;

import com.study.mvc.repository.CarRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("b")
public class CarServiceImpl2 implements CarRepository {



    @Override
    public List<String> getCarNames() {
        return List.of("k3","k5");
    }

    @Override
    public int insertCar(String carName) {
        System.out.println("등록된차량: " +carName);
        return 1;
    }


}
