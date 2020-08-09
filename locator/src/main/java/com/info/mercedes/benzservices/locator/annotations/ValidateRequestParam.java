package com.info.mercedes.benzservices.locator.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.info.mercedes.benzservices.locator.annotations.impl.RequestParamValidator;

@Target({ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = RequestParamValidator.class)

public @interface ValidateRequestParam {

	String message() default "invalid String";
	Class<?>[] groups() default { };
	Class<? extends Payload>[] payload() default { };
	String[] values() ;
}
