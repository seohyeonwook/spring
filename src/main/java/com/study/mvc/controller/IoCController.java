package com.study.mvc.controller;//diAndIoc

import com.fasterxml.jackson.core.JsonProcessingException;
import com.study.mvc.diAndIoc.DiRepository;
import com.study.mvc.diAndIoc.DiService;
import com.study.mvc.diAndIoc.IoCService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController// 여기도 원래 달아야하는데 controller안에 component있다 그래서안달아줘도됨
//@RequiredArgsConstructor //  오토와이어드 대신 사용할수 있다 대신 선언에 final 선언이 많으면 선언마다
                         // 오토와이어드 달아줘야하니까 이거씀

public class IoCController {

    @Autowired// 의존하는 애한테 단다
//    private final IoCService ioCService; //RequiredArgsConstructor사용할때 final
    private IoCService ioCService; //Autowired 랑 component 사용할때

    @GetMapping("/ioc") // 겟요청 들어오면 iocTest실행 ioCService에서 getJson실행
    public ResponseEntity<?> iocTest() throws JsonProcessingException {
      String json = ioCService.getJson();

        return ResponseEntity.ok(json);
    }
}
