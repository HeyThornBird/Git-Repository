package com.ruijie.annotation;


import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LogRecordAnnotation {
    /**
     * 日志描述
     */
    String description()  default "";

}
