package com.study.mvc.controller;

import com.study.mvc.dto.HelloDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController// 모든 메소드는 ResponseBody 붙는다 -> html만들수없다
public class StudyRestController {

    @GetMapping("/hello/test")
//    public String hello(String name, int age) {//name 이 들어오면 name에 넣어
//                                    //원래 주소창은 무조건 String 인데 자동형변환 해줌
//
////        System.out.println(request.getMethod());
////        System.out.println(request.getParameter("name"));
//        // 주소창에서 ?name=김준일 ? 키 밸류
//        // http://localhost:8080/hello/test?name=김준일
//
//        System.out.println(name);
//        System.out.println(age);
//        //http://localhost:8080/hello/test?name=김준일&age=31
//        // 만약 age빼먹으면 오류뜬다
//
//        return "Hello";
//    }
    public String hello(HelloDto helloDto) {// HelloDto 객체로 받아올수있다
        System.out.println(helloDto);
        return "Hello";
    }
}
