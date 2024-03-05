package com.study.mvc.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentRespDto {
    private String name ; //key
    private int age;
    private  String phone;
    private String address;
}
