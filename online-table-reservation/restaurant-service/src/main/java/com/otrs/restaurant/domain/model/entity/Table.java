package com.otrs.restaurant.domain.model.entity;

import java.math.BigInteger;

public class Table extends BaseEntity<BigInteger>{


	private int capacity;

	public Table(String name, BigInteger id,int capacity) {
		super(id, name);
		this.capacity= capacity;
	}


	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		return "Table [capacity=" + capacity + "]";
	}
	
	
}
