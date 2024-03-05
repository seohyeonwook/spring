package com.study.mvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.study.mvc.dto.StudentReqDto;
import com.study.mvc.dto.StudentRespDto;
import com.study.mvc.entity.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.spi.ObjectFactoryBuilder;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class StudentController {
    // @RequestBody 여기서 이게 제일 중요함 !!json타입으로 데이터 받을수 있음

    @PostMapping("/student")
    public ResponseEntity<?> addStudent(@CookieValue(required = false) String students, @RequestBody Student student) throws JsonProcessingException, UnsupportedEncodingException {

        ObjectMapper objectMapper = new ObjectMapper();

        List<Student> studentList = new ArrayList<>();

        int lastId = 0;

        System.out.println(students);

        if(students != null) {
            if(!students.isBlank()) {
                for(Object object : objectMapper.readValue(students, List.class)) {
                    Map<String, Object> studentMap = (Map<String, Object>) object;
                    studentList.add(objectMapper.convertValue(studentMap, Student.class));
                }
                lastId = studentList.get(studentList.size() - 1).getStudentId();
            }
        }

        student.setStudentId(lastId + 1);
        studentList.add(student);


        String studentListJson = objectMapper.writeValueAsString(studentList);

        System.out.println(studentListJson);

        ResponseCookie responseCookie = ResponseCookie
                .from("students", URLEncoder.encode(studentListJson, "UTF-8"))
                .httpOnly(true)
                .secure(true)
                .path("/")
                .maxAge(60)
                .build();

        // (")문자 저장x

        return ResponseEntity
                .created(null)
                .header(HttpHeaders.SET_COOKIE, responseCookie.toString())
                .body(student);
    }

    @GetMapping("/student")

    public ResponseEntity<?> getStudentInfo(StudentReqDto studentReqDto) {
        //ResponseEntity 무조건 이걸로 응답함 뒤에는 상태코드
        //?= 와일드카드 형 상관없이받을수있음
        //모든객체의 최상위는 Object
        System.out.println(studentReqDto);
        return ResponseEntity.ok().body(studentReqDto.toRespDto());
    }

    @GetMapping("/student/{studentId}")// 동적이어야해서 {} 묶음
    public ResponseEntity<?> getStudent(@PathVariable int studentId) {
        List<Student> sutdentList = List.of(
                new Student(1, "김준일"),
                new Student(2, "김준이"),
                new Student(3, "김준삼"),
                new Student(4, "김준사")
        );
        Student findStudent = null;
        for(Student student : sutdentList) {
            if(student.getStudentId() == studentId) {
                findStudent = student;
            }
            if(findStudent == null) {
                return ResponseEntity.badRequest().body(Map.of("errorMessage", "존재하지 않는 Id입니다"));
            }
        }

        return ResponseEntity.ok().body(findStudent);
    }
}
