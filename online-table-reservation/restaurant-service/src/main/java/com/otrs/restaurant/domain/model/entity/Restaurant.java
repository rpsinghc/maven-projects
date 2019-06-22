package com.otrs.restaurant.domain.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Restaurant extends BaseEntity<String>{
	
	private List<Table> tables = new ArrayList<Table>();
	   private String address;
	
	public Restaurant(String id, String name,List<Table> tables) {
		super(id, name);
		this.tables = tables;
	}

    public Restaurant(String name, String id, String Address, List<Table> tables) {
        super(id, name);
        this.address = address;
        this.tables = tables;
    }
    
 

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	@Override
	public String toString() {
		return "Restaurant [tables=" + tables + ", isModified=" + isModified + ", id=" + id + ", name=" + name + "]";
	}


		
	
	
}
