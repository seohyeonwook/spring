package com.study.mvc.dddd.day0308;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Study0308Controller {

    @Autowired
    private StudyService studyService;

    @PostMapping("/study0308")
    public ResponseEntity<?>insert(@RequestBody StudyReqDto studyReqDto) {

        return ResponseEntity.ok(studyService.createStudy(studyReqDto));
    }
}
