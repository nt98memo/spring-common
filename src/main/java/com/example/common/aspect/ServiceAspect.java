package com.example.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.example.common.entity.BaseEntity;
import com.example.common.service.BaseService;
import com.example.common.util.CurrentExecInfo;
import com.example.common.util.LogUtil;

public class ServiceAspect {

	@Value("${app-name}")
    protected String appName;

	@Autowired
	protected LogUtil logUtil;

	@Autowired
	protected CurrentExecInfo currentExecInfo;

	public ServiceAspect() {
	}

	@SuppressWarnings({"rawtypes"})
	public void insertBefore(JoinPoint joinPoint) {

		BaseService service = (BaseService)(joinPoint.getTarget());
		Object[] entityList = joinPoint.getArgs();
		if (entityList.length != 1) {
			return;
		}

		Object arg0 = entityList[0];
		if (!(arg0 instanceof BaseEntity)) {
			return;
		}

		BaseEntity entity = (BaseEntity)(arg0);

		entity.setCreateSystem(this.appName);
		entity.setCreateUserId(1L);
		entity.setCreateUrl(currentExecInfo.getExecName());
		entity.setUpdateSystem(null);
		entity.setUpdateUserId(null);
		
		StringBuilder sb = new StringBuilder();
		sb.append(service.toString()).append("#insertBefore:").append(entityList.toString());
		logUtil.debug(sb.toString());

	}

	@SuppressWarnings({"rawtypes"})
	public void insertAfter(JoinPoint joinPoint) {

		BaseService service = (BaseService)(joinPoint.getTarget());
		Object[] entityList = joinPoint.getArgs();
		
		StringBuilder sb = new StringBuilder();
		sb.append(service.toString()).append("#insertAfter:").append(entityList.toString());
		logUtil.debug(sb.toString());

	}

	@SuppressWarnings({"rawtypes"})
	public void updateBefore(JoinPoint joinPoint) {

		BaseService service = (BaseService)(joinPoint.getTarget());
		Object[] entityList = joinPoint.getArgs();
		if (entityList.length != 1) {
			return;
		}

		Object arg0 = entityList[0];
		if (!(arg0 instanceof BaseEntity)) {
			return;
		}

		BaseEntity entity = (BaseEntity)(arg0);

		entity.setUpdateSystem(this.appName);
		entity.setUpdateUserId(1L);
		entity.setUpdateUrl(currentExecInfo.getExecName());
		
		StringBuilder sb = new StringBuilder();
		sb.append(service.toString()).append("#updateBefore:").append(entityList.toString());
		logUtil.debug(sb.toString());

	}

	@SuppressWarnings({"rawtypes"})
	public void updateAfter(JoinPoint joinPoint) {

		BaseService service = (BaseService)(joinPoint.getTarget());
		Object[] entityList = joinPoint.getArgs();
		
		StringBuilder sb = new StringBuilder();
		sb.append(service.toString()).append("#updateAfter:").append(entityList.toString());
		logUtil.debug(sb.toString());

	}

	@SuppressWarnings({"rawtypes"})
	public void deleteBefore(JoinPoint joinPoint) {

		BaseService service = (BaseService)(joinPoint.getTarget());
		Object[] entityList = joinPoint.getArgs();
		
		StringBuilder sb = new StringBuilder();
		sb.append(service.toString()).append("#deleteBefore:").append(entityList.toString());
		logUtil.debug(sb.toString());

	}

	@SuppressWarnings({"rawtypes"})
	public void deleteAfter(JoinPoint joinPoint) {

		BaseService service = (BaseService)(joinPoint.getTarget());
		Object[] entityList = joinPoint.getArgs();
		
		StringBuilder sb = new StringBuilder();
		sb.append(service.toString()).append("#deleteAfter:").append(entityList.toString());
		logUtil.debug(sb.toString());

	}

	@SuppressWarnings({"rawtypes"})
	public void findBefore(JoinPoint joinPoint) {

		BaseService service = (BaseService)(joinPoint.getTarget());
		Object[] entityList = joinPoint.getArgs();
		
		StringBuilder sb = new StringBuilder();
		sb.append(service.toString()).append("#findBefore:").append(entityList.toString());
		logUtil.debug(sb.toString());

	}

	@SuppressWarnings({"rawtypes"})
	public void findAfter(JoinPoint joinPoint) {

		BaseService service = (BaseService)(joinPoint.getTarget());
		Object[] entityList = joinPoint.getArgs();
		
		StringBuilder sb = new StringBuilder();
		sb.append(service.toString()).append("#findAfter:").append(entityList.toString());
		logUtil.debug(sb.toString());

	}

}
