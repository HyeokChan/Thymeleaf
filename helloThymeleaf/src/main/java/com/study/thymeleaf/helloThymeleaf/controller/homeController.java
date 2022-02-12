package com.study.thymeleaf.helloThymeleaf.controller;

import com.study.thymeleaf.helloThymeleaf.domain.Literal;
import com.study.thymeleaf.helloThymeleaf.domain.Menu;
import com.study.thymeleaf.helloThymeleaf.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@Slf4j
@Controller
public class homeController {

    @GetMapping("/")
    public String home(Model model) {
        /*현재날짜*/
        model.addAttribute("today", Calendar.getInstance());
        /*사용자*/
        User user = new User(1L, "chan", "chan@naver.com");
        model.addAttribute("user", user);
        return "home";
    }

    @GetMapping("/literals")
    public String literalsForm(Model model) {
        Literal literal = new Literal();
        literal.setTrueValue(true);
        literal.setFalseValue(false);
        literal.setNullValue(null);
        model.addAttribute("literal", literal);
        return "literals";
    }

    @GetMapping("/product/list")
    public String productListForm(Model model) {

        return "product/list";
    }
}
