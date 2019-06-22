package com.otrs.restaurant.domain.repository;

import java.util.Collection;

import com.otrs.restaurant.domain.model.entity.Entity;

public interface ReadOnlyRepository<TE,T> {
	
	boolean containsId(T id);
	
	TE get(T id);
	
	Collection<TE> getAll();
	

}
