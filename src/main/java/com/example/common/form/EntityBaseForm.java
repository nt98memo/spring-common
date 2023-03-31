package com.example.common.form;

import com.example.common.entity.BaseEntity;

public abstract class EntityBaseForm<E extends BaseEntity> extends BaseForm {

	public abstract E getEntity();

	public abstract void setEntity(E entity);

}
