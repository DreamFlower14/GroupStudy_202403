package me.study.springbootdeveloper.Controller;

import me.study.springbootdeveloper.DAO.Blog.Member;
import me.study.springbootdeveloper.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// @RestController : 라우터 역할을 하는 어노테이션
// 라우터 : HTTP 요청 (클라이언트의 요청)과 함수를 연결하는 장치
@RestController
public class TestController {

    @Autowired  // TestService 빈 주입
    TestService testService;

    // /test GET 요청이 오면 test() 함수 실행
    @GetMapping("/test")
    public List<Member> getAllMembers(){
        System.out.println(getClass().getName() +".getAllMembers 시작!!!!");
        List<Member> members = testService.getAllMembers();
        System.out.println(getClass().getName() +".getAllMembers 끝!!!!");
        return members;
    }
}
