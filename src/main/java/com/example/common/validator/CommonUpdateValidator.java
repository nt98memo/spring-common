package com.example.common.validator;

import org.springframework.validation.Errors;

import jakarta.persistence.EntityManager;

public class CommonUpdateValidator extends BaseValidator {

	public CommonUpdateValidator() {
	}

	public void init(EntityManager entityManager) {
		super.init(entityManager);
	}
	
	@Override
	public void validate(Object target, Errors errors) {

	}

}
