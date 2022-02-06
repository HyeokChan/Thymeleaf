package com.study.thymeleaf.helloThymeleaf.controller;

import com.study.thymeleaf.helloThymeleaf.domain.Menu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class homeController {

    @GetMapping("/")
    public String home(Model model) {
        Menu menu = new Menu();
        menu.setMenuId(1L);
        menu.setMenuName("기본");
        menu.setMenuUrl("/home/basic");
        model.addAttribute("menu", menu);
        return "home";
    }

}
