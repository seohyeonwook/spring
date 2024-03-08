package com.study.mvc.dto;

import com.study.mvc.entity.Study;
import lombok.Data;

@Data //게터세터만들기
public class DBStudyReqDto {//0308-2
    // DTO는 서비스와 클라이언트 간 데이터 전송에 사용
    private String name;
    private int age;


    //업데이트용
    public Study toEntity (int id) {
        return Study.builder()
                .id(id)
                .name(name)
                .age(age)
                .build();
    }


}
