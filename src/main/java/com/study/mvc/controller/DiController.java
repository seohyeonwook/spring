package com.study.mvc.controller; //diAndIoc

import com.study.mvc.diAndIoc.DiRepository;
import com.study.mvc.diAndIoc.DiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
    class DiController {

        /**
         * Di(Dependency Injection) - 의존성 주입
         * 의존성 - 1이 2가없으면 아무것도 할수 없음  1이 2에서 데이터 가지고와야함
         */
        @GetMapping("/di")//핸들러
        //컨트롤러가 서비스를 의존하고 서비스는 레파지토리를 의존하고있따
        public ResponseEntity<?> diTest() { //어디선가 호출하고있다 호출하는곳을 찾아 여기서는 요청보내는곳(di)
            DiRepository diRepository = new DiRepository();//객체생성 -쓰려고 생성한건아님 서비스가 피료하니까 100번주소만들면
            // 자료형        자료형에 맞는것만 들어갈수 있다 int 면 숫자만
            // diRepository는 없으니까  new해서 생성하는ㄴ것
            // 변수와 메서드가 있는 주소(클래스)를 만든다***  아래. 찍는 기능을 쓰기위해서 만든다
            DiService diService = new DiService(diRepository); // new- 없는 메모리 주소를 만들어 준다 / 생성자 호출
                                                // 서비스에 매개변수 안넣어주면 빨간줄뜬다 이유는 서비스에서 매개변수
                                                // 안에 레파지토리를 넣어줬잖아 그래서 여기서도 매개변수값에 들어와야해
                                                // 여기 매개변수 넣어주려면 위에서 레파지토리 생성해야해
                                                // new DiService 랑 DiService랑 다른곳 가르키고있음

            Map<String, Object> responseData = // <>가 있다? 자료형이 변할 수 있다
                    Map.of(
                            "total", diService.getTotal(), // 호출- 여기로 리턴 값이 들어온다
                            "average", diService.getAverage() //서비스에 있는 x토탈이랑
                    );
            return ResponseEntity.ok(responseData);
        }

    }
    //자료형 - 참조/일반 두가지
    //참조 -일반은 리턴 값 (정수,실수,참거짓,스트링)
    // 참조가 결국 클래스- 내가 자료형 직접 만든느것 자료형의 집합
    // 클래스는 함수(기능)와 변수(데이터)
    /**
     * 함수만 이해하자 함수만 정확히 이해해도 읽는다.
     * 순서대로 동작하는것 - 프로그램 절대 순서를 어기지않음
     * = 시작점이 있고 종료하는곳이 있다
     * ex) 스프링부트는 메인(서버가 실행됨) -메인메서드부터 시작이다 - 메인이 종료되면 끝이다
     *      서블릿은 톰캣서버가 프로젝트를 불러서 실행함
     *      스프링부트는 메인이 실행이 되면 톰캣이 실행됨 ( 톰캣은 내장되어있어서)
     *      길을 가다 갈림길을 만난다고 생각하자  근데 왼쪽으로가면 오른쪽으로가는길이 동작하지않는다
     *      왼쪽으로 가면 왼쪽의 결과만 보고 오른쪽으로가면 오른쪽 결과만 본다
     *      반복문- 로타리라고생각하자 돌다가 나온다 -반복이 끝나고나면 도착점이있다 (제어의 흐름)
     *      예를 들어 내가 변호사를 쓸때 1을 쓰든 2를 쓰든 3을쓰든 변호를 한다는 동작을 정의하고
     *      변호사한테 변호를 해달라고한다 근데 정의를 안하면 필요할때마다 만들어야한다.
     *      필요할때마다 호출하면 된다. 정의한다/ 호출한다 -> mvcapplication에서
     *
     *      함수는 자료형을 정확히 이해해야해- 함수마다 이름과 매개변수가 다르다 이걸 이해해야해
     *                                     함수는 갯수와 자료형이 바뀐다
     *                                     매개변수의 자료형을 이해해야해
     *                                     어떤 동작(실행문) 매개변수와 함수명과 리턴 만 내가 잘 정하면됨
     *  정의 부분과 호출 부분을 잘 살펴보자 구조파악을 먼저 해야해
    */
