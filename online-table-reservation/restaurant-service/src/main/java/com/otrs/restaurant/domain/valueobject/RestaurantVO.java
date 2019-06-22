package com.otrs.restaurant.domain.valueobject;

import java.util.ArrayList;
import java.util.List;

import com.otrs.restaurant.domain.model.entity.Table;

public class RestaurantVO {
	List<Table> tables = new ArrayList<Table>();
	
	String name;
	String id;
	String address;
	public List<Table> getTables() {
		return tables;
	}
	public void setTables(List<Table> tables) {
		this.tables = tables;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "RestaurntVO [tables=" + tables + ", name=" + name + ", id=" + id + ", address=" + address + "]";
	}
	
}
