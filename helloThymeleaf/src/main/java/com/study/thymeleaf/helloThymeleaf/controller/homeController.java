package com.study.thymeleaf.helloThymeleaf.controller;

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

        /*메뉴*/
        Menu menu = new Menu();
        menu.setMenuId(1L);
        menu.setMenuName("기본");
        menu.setMenuUrl("/home/basic");
        model.addAttribute("menu", menu);
        return "home";
    }

    @GetMapping("/product/list")
    public String productListForm(Model model) {

        return "product/list";
    }
}
