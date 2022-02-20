package com.study.thymeleaf.helloThymeleaf.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Long userId;
    private String userName;
    private String userEml;
    private String userMblCpnc;
    private Role userRole;
}
