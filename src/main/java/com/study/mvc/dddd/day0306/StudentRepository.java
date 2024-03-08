package com.study.mvc.dddd.day0306;

import java.util.List;

public interface StudentRepository {

    public List<String> getStudentListAll();
    public String findStudentNameByIndex(int index);// 메서드 이름만보고 유추
}
