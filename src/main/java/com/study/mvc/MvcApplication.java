package com.study.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MvcApplication {

	public static void run() { //run이라고 하는 함수는 이런동작을 할겁니다 라는 정의
		System.out.println("기상");
		System.out.println("씻기");
		System.out.println("밥먹기");
		System.out.println("운동하기");
		System.out.println("공부하기");
	}

	public static String junil(int questionNumber) {
		// 함수가 하나의 일만 하면 매개변수
		// 필요없음 매개변수에 따라서 실행결과가 달라짐 그래서 매개변수 사용
		// 매개변수에 의해 동작이 바뀐다.
		// 객체를 매개변수로 주는이유도 같다
		// 학생을 객체로 넘겨주면 학생에대한 정보를 넘겨주는거임

		if(questionNumber == 1) {
			System.out.println("자바 질문에 답한다.");
		} else if (questionNumber == 2) {
			System.out.println("파이썬 질문에 답한다.");
		} else  {
			System.out.println("모른다고 답한다.");
		}
		return "자바 질문에 답한다.";
		// 리턴은 답을해주는것이라고 생각해 나혼자 알고있는게 아니라 호출한사람한테 대답해줘야지
		// 리턴에는 값만 들어갈수 있다
		// 근데 void는 리턴값이 없어 만약 리턴 에 "자바 질문에 답한다" 라고 하고싶을때
		//  void 대신 return자료형과 맞는 string을 단다
	}

	public static void main(String[] args) {
		run();//호출- 호출 안하면 정의는 출력안됨 당연하다ㅏㅏㅏㅏㅏㅏㅏㅏㅏ
//		junil(1); //그럼 리턴값의 자료형이 string이니까
//		String result = junil(1);
		// 이렇게 1에대한 대답을 스트링에 넣는다 이렇게 해도돼
		// 매개변수 넣고 호출하면서 result에 값넣는거
		System.out.println(junil(1));

		SpringApplication.run(MvcApplication.class, args);
	}

}
