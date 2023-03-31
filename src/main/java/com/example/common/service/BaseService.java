package com.example.common.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.common.dao.BaseDao;
import com.example.common.entity.BaseEntity;
import com.example.common.search.BaseSearchEntity;
import com.example.common.util.LogUtil;

import jakarta.persistence.EntityManager;

@SuppressWarnings("rawtypes")
public abstract class BaseService<SAVE extends BaseEntity, SEARCH extends BaseSearchEntity, REPOSITORY extends JpaRepository, DAO extends BaseDao> {
	
	@Autowired
	protected ApplicationContext context;

	protected EntityManager entityManager;

	@Autowired
	protected REPOSITORY repository;

	@Autowired
	protected LogUtil logUtil;

	protected DAO dao;

	public BaseService() {
	}

	public void init(EntityManager entityManager) {
		this.entityManager = entityManager;
		this.dao = this.getDao();
	}
	
    public abstract SAVE findById(Long id);

    public abstract SAVE findByIdForUpdate(Long id);

    public abstract void insert(SAVE entity);

    public abstract void update(SAVE entity);

    public abstract void delete(Long id);

    public abstract List<SAVE> find(SEARCH entity);
    
    @SuppressWarnings("unchecked")
	private DAO getDao() {
    	
    	try {

    		Type type = this.getClass().getGenericSuperclass();
    		ParameterizedType paramType = (ParameterizedType)type;
    		Type[] paramArgs = paramType.getActualTypeArguments();
    		Class<?> daoClass = (Class<?>)paramArgs[3];
    		Constructor<?> constructor = daoClass.getConstructor(EntityManager.class);
    		DAO dao = (DAO) constructor.newInstance(this.entityManager);
    		return dao;
    		
    	} catch (Exception e) {
    		logUtil.errorUrl();
			logUtil.writeException(e);
			throw new RuntimeException(e);
    	}

    }

}
