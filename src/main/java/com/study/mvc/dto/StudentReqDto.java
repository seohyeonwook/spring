package com.study.mvc.dto;

import lombok.Data;

@Data
public class StudentReqDto {
    private String name ; //key
    private int age;
    private  String phone;
    private String address;

    public StudentRespDto toRespDto() {
        return StudentRespDto.builder()
                .name(getName())
                .age(getAge())
                .phone(getPhone())
                .address(getAddress())
                .build();
    }
}
