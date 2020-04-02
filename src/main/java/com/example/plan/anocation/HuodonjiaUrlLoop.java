package com.example.plan.anocation;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HuodonjiaUrlLoop {
    String value() default "";
}
