package me.study.springbootdeveloper;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// @RestController : 라우터 역할을 하는 어노테이션
// 라우터 : HTTP 요청 (클라이언트의 요청)과 함수를 연결하는 장치
@RestController
public class TestController {
    @GetMapping("/test")
    public String test(){
        return "테스트";
    }
}
