package com.study.mvc.dddd.day0306;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private List<String> studentList = List.of("전주환", "서창현", "예홍렬");
    //전역으로 뺀 이유

    @Override
        public List<String> getStudentListAll() {
            return studentList;
    }

    @Override
    public String findStudentNameByIndex(int index) {

        return studentList.get(index);
    }
}
