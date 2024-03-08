package com.study.mvc.controller;

import com.study.mvc.dto.DBStudyReqDto;
import com.study.mvc.service.DBStudyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

///*
//* MySQL Connector Java 추가
//MyBatis Spring Boot Starter 2.2.2
//pom d은 저장하고 꼭 실행
//
//MyBati 사용하려면
//resources 안에 클래스 말고 디렉토리(mappers) 만들기
//
//그다음에 templates에 있는 application.yml 가기
//mybatis:
//  mapper-locations:
//    - /mappers/*.xml
//
// 이제 데이터베이스 세팅
//
//aws가기 데이터베이스 가기
//mysql-db
//누르고 엔드포인트(주소) 확인
//
//다시 yml가서
// jdbc:mysql:// 엔드포인트:3306/데이터베이스명
//작성하고 mysql db접속
//
//포스트맨 하는법 post는 바디에 raw에 json
//{
//    "name": "김준일",
//    "age" : 31
//}
//넣고 스프링 재실행 하고 send
//
//레파지토리 만들기
//mybatis 홈페이지에서 시작하기 매핑된sql구문 살펴보기
//복사해서 mappers에 파일로(클래스아님) 만들어서 study.xml 만들어서  붙여넣기
//
//*/

@RestController
public class DBController { //0308-1

    @Autowired//mybatis가 자체적으로 Component 가지고있다
    private DBStudyService dbStudyService;// 서비스에 createStudy 호출해주기위해서

    @PostMapping("/insert")//db에  tb에 데이터 넣으니까 tb만들어야함  //인설트랑 풋은 바디에 제이슨
    public ResponseEntity<?> insert(@RequestBody DBStudyReqDto dbStudyReqDto) {
                                    //제이슨 데이터 받을때
        System.out.println(dbStudyReqDto);// 포스트맨에서 받은 데이터를 디비로 보내줘야함
        // c - s -> r ->mybatis -> db

        return ResponseEntity.ok(dbStudyService.createStudy(dbStudyReqDto));// 호출해줌
        // 메서드는 정의다 메서드에서 실행되는게 아니라 호출한곳에서 실행됨 메서드는 그냥 도구
    }

    //insert로 요청이 들어옴 제이슨 데이터가 컨트롤러에 들어옴 객체로 생성해서 들어온 객체를 데이터베이스까지 보내느과정
// 컨트롤러 다음에 서비스에 createStudy메서드에  받아온 dbStudyReqDto 넘겨줌
// 서비스에서 스터디 엔티티로 바꿔야함 왜?? 레파지토리가 엔티티로만 받으니까 (디티오와엔티티 나누자 왜??명확하게 기능이다름)
// 리턴에서 레파지토리에 보내줌 레파지토리는 실제로 .xml이라서 xml에서 호출됨
// 엔티티에는 테이블 수 4개 디티오는 name이랑 age만 있다 그럼 데이터 넣어주면 나머지는 오토인크리먼트돼서
// 데이터베이스로간다 실행해서 성공하면 레파지토리에 리턴형 int가있으니까 성공한 횟수 1을 (postman화면)출력함
// 그리고 데이터베이스 가서 확인해보면 자료들어가있음

    @GetMapping("/select/study/{id}") //select = id 조회
    public ResponseEntity<?> selectStudy(@PathVariable int id) {
        return ResponseEntity.ok(dbStudyService.findStudyById(id));
    }

    @GetMapping("/select/study")  //?name=김준일 이런식으로 요청
    public ResponseEntity<?> selectStudy(@RequestParam String name) {
        return ResponseEntity.ok(dbStudyService.findStudyByName(name));
    }
    @GetMapping("/select/studys") // 전부
    public ResponseEntity<?> selectStudyAll() {
        return ResponseEntity.ok(dbStudyService.findAll());
    }

    @DeleteMapping("/delete/study/{id}") //삭제
    public ResponseEntity<?> deleteStudy(@PathVariable int id) {
        return ResponseEntity.ok(dbStudyService.deleteById(id));
    }

    // put 과 patch는 이름만 명시일뿐 안에 로직은 우리가 만들어줘야함  풋은 바디에 제이슨
    @PutMapping("/update/study/{id}") //업데이트 1 -put 전체수정 -빈값있으면 빈값으로 바꾸고 저장
    public ResponseEntity<?> putStudy(
            @PathVariable int id, //몇번쨰 아이디 수정할건지 아래는 수정할 ㄷ데이터
            @RequestBody DBStudyReqDto dbStudyReqDto) {

        return ResponseEntity.ok(dbStudyService.putById(id,dbStudyReqDto));
    }

    @PatchMapping("/update/study/{id}") //업데이트2 -patch 부분수정 -빈값 널값은 수정할 내용이아니라고 판단
                                        // 값이 넘어온 애들만 수정 빈값넘어온건 그 전 데이터 그대로 잘 안씀
    public ResponseEntity<?> patchStudy(
            @PathVariable int id, //몇번쨰 아이디 수정할건지 아래는 수정할 ㄷ데이터
            @RequestBody DBStudyReqDto dbStudyReqDto) {

        return ResponseEntity.ok(dbStudyService.patchById(id,dbStudyReqDto));
    }

}
