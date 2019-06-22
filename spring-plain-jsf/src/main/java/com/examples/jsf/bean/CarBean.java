package com.examples.jsf.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@ManagedBean
@RequestScoped
public class CarBean {

	@Autowired
	CarDao carDao;

	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	public List<String> fetchCarDetails() {

		return carDao.getCarDetails();
	}

}
