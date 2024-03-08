package com.study.mvc.dddd.day0306;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestController {

    @Autowired
    @Qualifier("studentServiceImpl")
    private StudentService studentService;

    @GetMapping("/ex/students")
    public ResponseEntity<?> students() {

        return ResponseEntity.ok(studentService.getStudentList());
    }

    @GetMapping("/ex/student/{index}")// 인덱스 값 넣어서 조회
    public ResponseEntity<?> student(@PathVariable int index) {
        //PathVariable 매핑에 인덱스 매개변수로 받아와서 검색하기 위해??
        return ResponseEntity.ok(studentService.getStudent(index));
    }

}
