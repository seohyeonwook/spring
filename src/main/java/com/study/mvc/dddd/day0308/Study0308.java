package com.study.mvc.dddd.day0308;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//@NoArgsConstructor
//@AllArgsConstructor
@Builder
@Data
public class Study0308 {
    private int id;
    private String name;
    private int age;
    private LocalDateTime createDto;
}
