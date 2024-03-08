package com.study.mvc.dddd.day0306;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;



    @Override
    public List<?> getStudentList() {
        List<Map<String, String>> studentMapList = new ArrayList<>(); //리스트 안에 맵이 들어가야함 키 밸류 키 밸류
        List<String> studentList = studentRepository.getStudentListAll();

        for(String studentName : studentList) {
            studentMapList.add(Map.of("name", studentName));//studentMapList에 채워야 키밸류 형태로 나옴
        }

        return studentMapList;
    }

    @Override
    public Object getStudent(int index) {
        String studentName = studentRepository.findStudentNameByIndex(index);
        return Map.of("name", studentName);
    }
}


