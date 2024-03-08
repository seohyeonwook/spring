package com.study.mvc.dddd.day0308;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudyService {
    @Autowired
    private StudyRepository studyRepository;

    public int createStudy(StudyReqDto studyReqDto) {
        Study0308 study0308 = Study0308.builder()
                .name(studyReqDto.getName())
                .age(studyReqDto.getAge())
                .build();

        return studyRepository.save(study0308);
    }

}
