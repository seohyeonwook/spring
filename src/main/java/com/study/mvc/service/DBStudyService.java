package com.study.mvc.service;


import com.study.mvc.dto.DBStudyReqDto;
import com.study.mvc.dto.DBStudySelectRespDto;
import com.study.mvc.dto.DBStudyinsertRespDto;
import com.study.mvc.entity.Study;
import com.study.mvc.repository.DBStudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

// 서비스 - 엔티티랑 디티오 변환하는거
public class DBStudyService { //0308-6
    @Autowired // 달려면 DBStudyRepository에 컴포넌트가있어야하는데 interface는 못단다
    // 근데 연결되어있는 .xml이 컴포넌트라서 가능
    private DBStudyRepository dbStudyRepository;

//    public int createStudy(DBStudyReqDto dbStudyReqDto) {
//
//        //dto를 netity로 바꾸는 작업 -몇가지
////        Study study = new Study(0, dbStudyReqDto.getName(),dbStudyReqDto.getAge(),null);
//        //all 방법 all사용하려면 다 채워 넣어야함 - &&&&&1번방법&&&&&&
//
////        Study study = new Study();
////        study.setName(dbStudyReqDto.getName());
////        study.setAge(dbStudyReqDto.getAge());
//        //no 방법 &&&&&&2번방법&&&&&&
//
//        Study study = Study.builder() // 디티오 받아와서 스터디 엔티티로 변환하는 작업
//                .name(dbStudyReqDto.getName())
//                .age(dbStudyReqDto.getAge())
//                .build();
//        //&&&&&&&&&3.빌더방법&&&&&& 이거 쓰려면 no랑 all지워줘야함
//
//
//
//        return dbStudyRepository.save(study);
    //여기까지는 요청 밑에는 응답할때

    public DBStudyinsertRespDto createStudy(DBStudyReqDto dbStudyReqDto) {

        Study findStudy = dbStudyRepository.findStudyByName(dbStudyReqDto.getName());
        //중복 찾기= 있거나 null이거나 중복이면 insert 안됨
        if (findStudy != null) {
            return DBStudyinsertRespDto.builder()
                    .successStatus(false)
                    .build();
        }

        Study study = Study.builder() // 디티오 받아와서 스터디 엔티티로 변환하는 작업
                .name(dbStudyReqDto.getName())
                .age(dbStudyReqDto.getAge())
                .build();

        int successCount = dbStudyRepository.save(study);

        DBStudyinsertRespDto dbStudyinsertRespDto = DBStudyinsertRespDto.builder()
                .id(study.getId())
                .name(study.getName())
                .age(study.getAge())
                .successStatus(successCount > 0)
                .successCount(successCount)
                .build();

        return dbStudyinsertRespDto;
    }

    public DBStudySelectRespDto findStudyById(int id) { //select = 조회

        Study study = dbStudyRepository.findStudyById(id);

        System.out.println(study);

        DBStudySelectRespDto dbStudySelectRespDto =
                DBStudySelectRespDto.builder()
                        .id(study.getId())
                        .name(study.getName())
                        .age(study.getAge())
                        .build();

        return dbStudySelectRespDto;
    }

    public DBStudySelectRespDto findStudyByName(String name) { //todto만들어서 (Stduy클래스)써보기
        Study study = dbStudyRepository.findStudyByName(name);
        return study == null ? null : study.toDto();// ex)김준삼같이 없는 데이터로 조회했을때
    }
//-----------------------------------------------------
    public List<DBStudySelectRespDto> findAll() { //전부 찾기
        List<DBStudySelectRespDto> respDtoList = new ArrayList<>();//비어있는 리스트만들어서 담아줘야함
        List<Study> studyList = dbStudyRepository.findAll();
        for (Study study : studyList) {
            respDtoList.add(study.toDto());
        }
        return respDtoList;
    }

    public List<DBStudySelectRespDto> findAll2() { //위에를 아래 스트림 방법으로 바꾼거 위에꺼 먼저 이해하자

        return dbStudyRepository.findAll()
                .stream()
                .map(Study::toDto)
                .collect(Collectors.toList());
    }
//-----------------------------------------------------
    public int deleteById(int id) { //삭제
        return dbStudyRepository.deleteById(id);
    }
    //-----------------------------------------------------

    public int putById(int id, DBStudyReqDto dbStudyReqDto) {
        return  dbStudyRepository.putById(dbStudyReqDto.toEntity(id));
    }

    public int patchById(int id, DBStudyReqDto dbStudyReqDto) {
        return  dbStudyRepository.putById(dbStudyReqDto.toEntity(id));
    }
}

