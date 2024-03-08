package com.study.mvc.repository;


import com.study.mvc.entity.Study;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper//레파지토리에 다는것
public interface DBStudyRepository {//0308-3 (이제부터 레파지토리안에는 인터페이스 하나만 만든다)
                                    //테이블 하나당 레파지토리 하나
    public int save(Study study);
    //여기서 study.xml같이보자 그게 임플리먼츠 한 클래스라고 생각하자
    //insert  무조건 숫자로 나옴 그래서 자료형 int
    //결국엔 여기서 1을 받아서 다시 리턴으로 타고타고타고 최종 호출이 시작된 곳으로 가네

    public Study findStudyById(int id);//select//호출되고나면 스터디 객체 하나 가지고온다

    public Study findStudyByName(String name);// name(유니크 키값) 기준으로 찾겠다

    public List<Study> findAll();// 전부 찾기 // List면 리턴 안적어도  바티스가 알아서 리스트로가져옴
    //조회했을때 두개이상이 나올 경우는 무조건 List써야함

    public int deleteById(int id); //삭제

    public int putById(Study study);
    public int patchById(Study study);


}


