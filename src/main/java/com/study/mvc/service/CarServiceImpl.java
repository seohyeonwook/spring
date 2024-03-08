package com.study.mvc.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.mvc.repository.CarRepository;
import com.study.mvc.repository.CarRepositoyImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // Repository Service 이렇게 3개 같다

public class CarServiceImpl implements CarService {


    @Autowired
    @Qualifier("a")//오토하고싶은데 객체가 Impl 이 두개라서 뭘해야할지 모르겠다 라고할때 사용
                    // 주입하고싶은 컴포넌트 명 가지고 오면 됨

    private CarRepository carRepository;
    // 선언 했는데 implements CarRepository 1 2 가 있어서 멀 가지고 올지 모르겠다

    // 인터페이스 사용이유- 여러개의 객체를 업캐스팅 할수있다
    //업캐스팅한뒤에 다운 캐스팅 하는이유- 자식이 따로 가지고 있는게 있을때
//    private CarRepository carRepository = new CarRepositoyImpl2();

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public String getCarNames() {
       return String.join(", ", carRepository.getCarNames());
       //문자열: 아반뚜ㅖ, 소나똬
    }

    @Override
    public int addCar(String carName) {
        return 0;
    }
}
