package com.humanbooster.f00d.anderson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.f00d.anderson.business.Restaurant;
import com.humanbooster.f00d.anderson.dao.RestaurantDao;
import com.humanbooster.f00d.anderson.service.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private RestaurantDao service;

	@Override
	public void CreateRestaurant(String nom, String description, String addressL1, String addressL2,
			String codePostal) {
		service.create(new Restaurant(nom, description, addressL1, addressL2, codePostal));

	}

	@Override
	public List<Restaurant> targetRestaurant() {
		return service.findAll();

	}

	@Override
	public Restaurant targetRestaurantByd(int idRest) {
		return service.findById(idRest);
	}
}
