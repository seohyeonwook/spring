package com.study.mvc.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DBStudyinsertRespDto {//0308-7 //응답 할때는 내가 고르기 가능
    private int id;
    private String name;
    private int age;
    private boolean successStatus;
    private int successCount;
}
