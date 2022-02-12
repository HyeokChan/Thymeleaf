package com.study.thymeleaf.helloThymeleaf.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

@Getter @Setter
public class Literal {
    private boolean trueValue;
    private boolean falseValue;
    private Nullable nullValue;
}
