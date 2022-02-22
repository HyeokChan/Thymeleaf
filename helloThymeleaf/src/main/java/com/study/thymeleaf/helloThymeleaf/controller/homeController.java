package com.study.thymeleaf.helloThymeleaf.controller;

import com.study.thymeleaf.helloThymeleaf.domain.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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

    @GetMapping("/attribute")
    public String attributeForm(Model model) {
        Attribute attribute = new Attribute();
        attribute.setSubBtnText("Subscribe");
        model.addAttribute("attribute", attribute);
        return "menu/attribute";
    }

    @GetMapping("/iteration")
    public String iterationForm(Model model) {
        List<Prod> prods = createProds();
        model.addAttribute("prods", prods);
        return "menu/iteration";
    }

    @GetMapping("/conditionalEvaluation")
    public String conditionalEvaluationForm(Model model) {
        List<Prod> prods = createProds();
        List<User> users = createUsers();
        model.addAttribute("prods", prods);
        model.addAttribute("users", users);
        return "menu/conditionalEvaluation";
    }

    @GetMapping("/conditionalEvaluationComments{prodId}")
    public String commentsForm(@PathVariable String prodId, Model model) {

        return "prod/comments";
    }

    @GetMapping("/localVariables")
    public String localVariablesForm(Model model) {
        List<Prod> prods = createProds();
        model.addAttribute("prods", prods);
        model.addAttribute("today", Calendar.getInstance());

        return "menu/localVariables";
    }

    private List<Prod> createProds() {
        List<Prod> prods = new ArrayList<>();
        for (int i = 1; i < 5; i++) {
            Prod prod = new Prod();
            prod.setProdId(Long.valueOf(i));
            prod.setProdName("Product" + i);
            prod.setProdAmt(i * 10000);
            List<Comment> comments = createComments(i);
            prod.setComments(comments);
            prods.add(prod);
        }
        return prods;
    }

    private List<Comment> createComments(int i) {
        List<Comment> comments = new ArrayList<>();
        for (int j = 1; j < i; j++) {
            Comment comment = new Comment();
            comment.setCommentId(Long.valueOf(j));
            comment.setCommentCn("comment" + i + "-" + j);
            comments.add(comment);
        }
        return comments;
    }

    private List<User> createUsers() {
        List<User> users = new ArrayList<>();
        User userA = new User();
        userA.setUserId(1L);
        userA.setUserName("userA");
        userA.setUserRole(Role.ADMIN);
        User userB = new User();
        userB.setUserId(2L);
        userB.setUserName("userB");
        userB.setUserRole(Role.MANAGER);
        User userC = new User();
        userC.setUserId(2L);
        userC.setUserName("userC");
        userC.setUserRole(Role.GUEST);
        users.add(userA);
        users.add(userB);
        users.add(userC);
        return users;
    }

}
