package com.study.mvc.diAndIoc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Objects;

@Component // 자동으로 new해줌 - 이거대신에 리콰이어드 사용가능 (컨트롤러에서 확인)
// 어노테이션은 스프링 프레임워크에서 컴포넌트 스캔(Component Scanning)
// 기능을 사용하여 해당 클래스를 스프링 빈으로 등록하는 역할을 합니다.

public class IoCService {

    @Autowired //component 달고 필요한 곳 위에 Autowired달면 자동으로 new 해줌
                // 그럼 IocRepository ioc = IocRepository 안해줘도 됨
                // 순서가 중요함 의존 안하는 애들 순서로 달아줘야함
                // 레파지토리(의존하는애없음) -> 서비스(레파지토리의존함) -> 컨트롤(서비스 의존함)
                // 근데 모든 클래스에 달면 안된다 - 하나만 생성된다 / 컴포넌트들끼만 Ioc가 됨(컴퍼넌트없으면 오토와이드안됨)
    private IoCRepository ioCRepository;

    public String getJson() throws JsonProcessingException {
       Map<String, String> nameMap = ioCRepository.convertNameMap();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(nameMap);
    }
}
// ioc사용이유 - 하나만 등록해놓고 여러곳에서 공유해서 쓰기때문에 (싱글톤)
