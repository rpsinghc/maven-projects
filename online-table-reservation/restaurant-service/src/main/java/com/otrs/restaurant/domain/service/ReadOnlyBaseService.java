package com.otrs.restaurant.domain.service;

import com.otrs.restaurant.domain.repository.Repository;

public class ReadOnlyBaseService<TE,T> {
	private Repository<TE,T> repository;
	
	public ReadOnlyBaseService(Repository<TE, T> repository){
		this.repository = repository;
	}
}
