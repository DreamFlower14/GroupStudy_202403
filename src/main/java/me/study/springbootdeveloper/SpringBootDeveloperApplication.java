package me.study.springbootdeveloper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 메인 클래스로 사용하기 위한 이름 지정 <프로젝트 이름> <Application>
// @SpringBootApplication : 클래스를 메인 클래스로 사용하기 위해 추가한 어노테이션
@SpringBootApplication
public class SpringBootDeveloperApplication {
    public static void main(String[] args){
        SpringApplication.run(SpringBootDeveloperApplication.class, args);
    }
}
