package com.example.common.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.example.common.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;

public abstract class EntityListBaseForm<E extends BaseEntity> extends BaseForm {

	@Getter @Setter
	private List<Map<String, String>> orderBy = new ArrayList<Map<String, String>>();

	@Getter @Setter
	private Long limit;

	@Getter @Setter
	private Long offset;
	
	public abstract List<E> getEntityList();

	public abstract void setEntityList(List<E> entityList);

}
