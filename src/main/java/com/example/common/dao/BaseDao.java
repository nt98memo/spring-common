package com.example.common.dao;

import jakarta.persistence.EntityManager;

public class BaseDao {

	protected EntityManager entityManager;
	
	public BaseDao() {
		super();
	}
	
	public BaseDao(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
}
