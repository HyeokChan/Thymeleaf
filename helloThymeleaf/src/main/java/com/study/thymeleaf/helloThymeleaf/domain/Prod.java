package com.study.thymeleaf.helloThymeleaf.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Prod {
    private Long prodId;
    private String prodName;
    private int prodAmt;
    private List<Comment> comments;
}
