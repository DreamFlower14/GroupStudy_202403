package me.study.springbootdeveloper.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class FetchTest {
    @GetMapping("/fetch/test")
    public String selectTest(Model model){
        return "example";
    }
}
