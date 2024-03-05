package com.study.mvc.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class HelloDto { //dto에 AllArgsConstructor 랑 Builder쓰지마
    private String name;
    private int age;
}
