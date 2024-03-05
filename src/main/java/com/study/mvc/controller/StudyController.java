package com.study.mvc.controller;

import com.study.mvc.model.HelloModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class StudyController {
    // mvc
    @GetMapping("/hello") //c +f5 재실행 // http://localhost:8080/hello 들어가서 확이ㅏㄴ
    // getMapping(주소)
    //이게 요청 보내는거임 doget dopost 대신 걍 이렇게 만들면 됨
    // 원래 /hello /test 이렇게 할떄마다 서블릿 하나씩 만들어줘야하는데
    // 이제 controller하나 만들어서 그안에(한클래스)서 메소드를 늘려서 요청늘림
    // 매핑은 하나만 적용 가능

//    public ModelAndView helloPage1(Model model) { //매개변수 model 안받고 Map사용 가능
//        //ModelAndView = 객체(객체는 주소를 가진다) = new
//        model.addAttribute("name1", "김준일");
//        model.addAttribute("name2", "김준이");
//        model.addAttribute("name3", "김준삼");
////        Map<String, Object> model = new HashMap<>();
////        model.put("name1","김준일");
////        model.put("name2","김준이");
////        model.put("name3","김준삼");
//        return new ModelAndView("hello"); //, map쓰면 hello뒤에 medel들어감
//        //                       html 파일명
//    }

    public String helloPage2(Model model) {// model파일이랑 연결
        HelloModel helloModel = HelloModel.builder()
                .name1("김준일")
                .name2("김준이")
                .name3("김준삼")
                .build();
        model.addAttribute("h", helloModel);
        return "hello";
    }

    // rest
    @GetMapping("/test")
    @ResponseBody//응답 body(데이터) 응답을 데이터로하겠다
    // 근데 데이터로 응답하면 viewname (return new ModelAndView("hello");
    // 을 리턴하는게 아니라 return에 있는 test를 응답해준다
    // 그럼 꼭 String일 필요가없다 Map써도 된다
    // 그럼 html로 안가고 여기서 처리한다

    public Map<String, Object> testPage() { //맵으로 리턴하면 제이슨객체로 자동으로 바꿔준다 f12
        Map<String, Object> testObj = new HashMap<>();
        testObj.put("age", 32);
        return testObj;
    }

    public String testPage1(Model model) { //ResponseBody 있어서 안됨
        model.addAttribute("age", 32); //String은 view name만 쓸수있다
//        return new String("test");
        return "test";

        // ModelAndView , String 같다
        // 차이점 - 잘모르게따
    }
}
