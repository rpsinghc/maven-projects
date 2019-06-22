package com.otrs.restaurant.domain.service;

import java.util.Collection;

import com.otrs.restaurant.domain.model.entity.Entity;
import com.otrs.restaurant.domain.repository.Repository;

public abstract class BaseService<TE,T>   extends ReadOnlyBaseService<TE,T> {

	
	Repository<TE, T> _repository;

	public BaseService(Repository<TE, T> repository) {
		super(repository);
		this._repository = repository;
	}

	void add(TE entity) throws Exception {
		_repository.add(entity);
	}
	
	
	public Collection<TE> getAll() {
		return _repository.getAll();
	}
	
	public TE findByid(T id){
		return _repository.get(id);
	}
	
}
