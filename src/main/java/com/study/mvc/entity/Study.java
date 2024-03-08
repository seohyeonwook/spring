package com.study.mvc.entity;

import com.study.mvc.dto.DBStudySelectRespDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data // date만 있으면 all만 있어서 무조건 순서대로 다 가져와야한다
public class Study {//0308-5 //테이블명이랑 똑같이 만들어주고 컬럼이랑 똑같이만들어ㅑ줘야함
    // 엔티티는 데이터베이스와의 상호 작용을 위해 사용되고
    private int id;
    private String name;
    private int age;
    private LocalDateTime createDate;

    public DBStudySelectRespDto toDto() {
        return DBStudySelectRespDto.builder() //빌더패턴으로 생성해서  DBStudySelectRespDto에 리턴해준다
                .id(id)
                .name(name)
                .age(age)
                .build();
    }
}

//레파지토리와 디비 사이에서 이어주는게 엔티티
// 클라이언트랑 서버 사이에왔다갔다하는건 제이슨  제이슨 들어온 서버는 디티오로 변경돼서 컨트롤러로 감
// 클라이언트 ->(제이슨) 서비스 ->(디티오) 컨트롤러 ->(
// 레파지토리 <->(엔티티) 데이터베이스


//다음 호출의 매개변수로 들어간다