package com.study.thymeleaf.helloThymeleaf.controller;

import com.study.thymeleaf.helloThymeleaf.domain.Conditional;
import com.study.thymeleaf.helloThymeleaf.domain.Literal;
import com.study.thymeleaf.helloThymeleaf.domain.Operation;
import com.study.thymeleaf.helloThymeleaf.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;

@Slf4j
@Controller
public class homeController {

    @GetMapping("/")
    public String home(Model model) {
        /*현재날짜*/
        model.addAttribute("today", Calendar.getInstance());
        /*사용자*/
        User user = new User();
        user.setUserId(1L);
        user.setUserName("chan");
        user.setUserEml("chan@naver.com");
        model.addAttribute("user", user);
        return "home";
    }

    @GetMapping("/literals")
    public String literalsForm(Model model) {
        Literal literal = new Literal();
        literal.setTrueValue(true);
        literal.setFalseValue(false);
        literal.setNullValue(null);
        /*사용자*/
        User user = new User();
        user.setUserId(2L);
        user.setUserName("chan");
        user.setUserEml("chan@naver.com");
        model.addAttribute("user", user);
        model.addAttribute("literal", literal);
        return "menu/literals";
    }

    @GetMapping("/operations")
    public String operationsForm(Model model) {
        Operation operation = new Operation();
        operation.setAmCount(2);
        operation.setCpCount(3);
        operation.setCpMode("dev");
        model.addAttribute("operation", operation);
        return "menu/operations";
    }

    @GetMapping("/conditional")
    public String conditionalForm(Model model) {
        Conditional conditional = new Conditional();
        conditional.setEvenValue(2);
        conditional.setEvenBoolValue(true);
        User user = new User();
        user.setUserId(3L);
        user.setUserName("chan");
        model.addAttribute("conditional", conditional);
        model.addAttribute("user", user);
        return "menu/conditional";
    }

}
