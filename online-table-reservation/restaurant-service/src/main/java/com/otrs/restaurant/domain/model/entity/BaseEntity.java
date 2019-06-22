package com.otrs.restaurant.domain.model.entity;

public abstract class BaseEntity<T>  extends Entity<T>{

	
	public boolean isModified;

	public BaseEntity(T id, String name) {
		super.id = id;
		super.name = name;
		this.isModified = false;
	}

	public boolean isModified() {
		return isModified;
	}

	public void setModified(boolean isModified) {
		this.isModified = isModified;
	}
	
}
