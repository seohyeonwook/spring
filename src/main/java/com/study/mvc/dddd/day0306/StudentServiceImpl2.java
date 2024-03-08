package com.study.mvc.dddd.day0306;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl2 implements StudentService{


    //@@@@@@@@@@@@@@@@@@Dto로 만들기@@@@@@@@@@@@@@@@@@@@@@
    private final StudentRepository studentRepository;



    @Override
    public List<?> getStudentList() {
        List<StudentExDto> studentDtoList = new ArrayList<>(); //리스트 안에 맵이 들어가야함 키 밸류 키 밸류
        List<String> studentList = studentRepository.getStudentListAll();

        for(String studentName : studentList) {
            studentDtoList.add(new StudentExDto(studentName));//studentMapList에 채워야 키밸류 형태로 나옴
        }

        return studentDtoList;
    }

    @Override
    public Object getStudent(int index) {
        String studentName = studentRepository.findStudentNameByIndex(index);

        return new StudentExDto(studentName);
    }
}


