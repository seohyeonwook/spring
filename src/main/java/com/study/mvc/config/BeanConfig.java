package com.study.mvc.config;
// config는 보통 설정을 관리하는곳 util

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;


@Configuration
// Bean 수동 등록 (2개이상 등록 가능)
public class BeanConfig {


    @Bean // 함수이름이 컴포넌트 이름이 됨 -
    public ObjectMapper objectMapper() {
        return new ObjectMapper();// 리턴되는 값이ioc에 등록된다
        // ioc에 등록되어야지만 라이브러리 는 수정이 안된다 그래서 여기서Configuration 달고 직접생성하고

        // 라이브러리 안에있는걸 ioc로 등록하고 싶을때 사용한다  이렇게하면 다른곳에서 오토와이드 해서 사용가능
//        ex @Autowired
//                private ObjectMapper objectMapper;

        // CarServiceImpl 가서 확인해보자
    }
}
