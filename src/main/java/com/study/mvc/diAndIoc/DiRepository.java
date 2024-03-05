package com.study.mvc.diAndIoc;

import java.util.List;

public class DiRepository {

    private List<Integer> scoreList = List.of(100, 90, 80, 70);
                            // scoreList 바로 못가지고 나오는이유 getter setter알아보자
                            // getter setter 일종의 약속같은거임 정보은닉을위해 그래서 다 get set쓴다
    public List<Integer> getScoreList() { // private이라 여기에 public만들고 외부에서 get쓴다
        return scoreList;// integer담은 리스트를 반환
    }
}
