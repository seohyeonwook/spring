package com.study.mvc.dddd.day0308;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudyRepository {

    public int save(Study0308 study0308);
}
