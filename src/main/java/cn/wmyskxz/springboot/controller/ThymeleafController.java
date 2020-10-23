package cn.wmyskxz.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {
    @GetMapping("/thymeleaf")
    public String index(ModelMap map) {
        return "thymeleaf";
    }
}
