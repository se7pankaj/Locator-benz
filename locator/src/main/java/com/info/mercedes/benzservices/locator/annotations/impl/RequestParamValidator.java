package com.info.mercedes.benzservices.locator.annotations.impl;

import java.util.Arrays;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.info.mercedes.benzservices.locator.annotations.ValidateRequestParam;

public class RequestParamValidator implements ConstraintValidator<ValidateRequestParam, String>{

	private String[] options;
	
	@Override
	public void initialize(ValidateRequestParam obj) {
		this.options = obj.values();
	}
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value==null) {
			return true;
		}
		if(Arrays.asList(options).contains(value)) {
			return true;
		}
		return false;
	}

}
