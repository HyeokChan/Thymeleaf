package com.study.thymeleaf.helloThymeleaf.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long userId;
    private String userName;
    private String userEml;

    public User(Long userId, String userName, String userEml) {
        this.userId = userId;
        this.userName = userName;
        this.userEml = userEml;
    }
}
