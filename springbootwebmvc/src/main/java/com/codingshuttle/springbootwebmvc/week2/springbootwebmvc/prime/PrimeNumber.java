package com.codingshuttle.springbootwebmvc.week2.springbootwebmvc.prime;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Constraint(validatedBy = PrimeNumberValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface PrimeNumber {
    String message() default "The number must be a prime number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
