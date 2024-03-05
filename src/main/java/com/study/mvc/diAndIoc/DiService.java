package com.study.mvc.diAndIoc;

import java.util.List;

public class DiService { // 이게 생성되어야지만  밑에 new가 되기때문에 선언만 하고 Service new 할때
                        // 매개변수로 Repository 부품을 건내주고 생성자에서 매개변수로 받아서
   // private DiRepository diRepository = new DiRepository()

    private DiRepository diRepository;//여기에 아래 레파지토리가 들어옴 그래서 이걸가지고 계산함 계산값을가지고
        // Repository 기능을 외부에서 받아와서 선언에서 아래에서 사용하겠다
        // 컨트롤러 맵에들어가서  표시함
        // private 사용이유 - 정보은닉 - 안전장치
        // 생성과 선언은 다름 얘는 선언 -선언하는이유- 전달하려고 생성하지않고
        // 선언도 똑같다 int a; 도 선언이잖아 어렵게 생각하지 말자
        // 전역으로 뺌 - 하나의 주소만 쓰자
    public DiService(DiRepository diRepository){//생성되어질떄 매개변수로 받아와서 -그냥 저장소 int a 라생각하자
        // DiRepository diRepository이런 매개변수는 어디선가 new가 돼서
        // new 한게 생성과 호출이다 - 호출 하면 만들어지는게 이 메서드(생성자)인데 생성자는 리턴이 없다.
        // 생성자 생성 목적- 클래스 사용을 위해서
        this.diRepository = diRepository; //원래 여기서 new인데 그럼 서비스가 만들어져야지 레파지토리가 만들어지니까
        // 여기다가 그냥 매개변수로 레파지토리줘서 저장소로 만들어서 컨트롤러에서 서비스new할때 바로 매개변수로 레파지토리
        // 넣어서 사용하려고

    }

    //클래스가 생성됨가 동시에 new해서 Repository 전역에 만들어준다

    public int getTotal() { //diRepository에서 값 안가지고 오면 getTotal
        // DiRepository diRepository = new DiRepository();
        // 이렇게하고 위에 없다고 생각하면 함수 쓸때마다 계속 new해줘야함
        // 그럼 결합도가 높으니까 전역으로 빼자 위에서
        int total = 0;
        List<Integer> scoreList = diRepository.getScoreList();// 서비스가 레파지토리 의존 중
        for(Integer score : scoreList) { // 향상된 for 문 List에서 하나씩 꺼내서 score에 하나씩 집어넣는다
            total += score;
        }
        return total;
    }

    public double getAverage() {
        double avg = 0;
        int total = 0;
        List<Integer> scoreList = diRepository.getScoreList();
        for(Integer score : scoreList) {
            total += score;
        }
        avg = total / scoreList.size();

        return avg;
    }
}
