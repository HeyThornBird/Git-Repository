package com.ruijie.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy =ValidParamsOnFlagValidator.class )
public @interface ValidParamsOnFlag {

    String message() default "必填参数不能为空串";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}

