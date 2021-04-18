package com.epolsoft.match.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TalentDtoInValidator.class)
public @interface TalentDtoInConstraint {

    String message() default "Invalid talent";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}