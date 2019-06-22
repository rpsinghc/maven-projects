package com.otrs.restaurant.domain.repository;

public interface Repository<TE,T> extends ReadOnlyRepository<TE, T> {
	void  update(TE entity);
	
	void add(TE entity);
	
	void remove(T id);

}
