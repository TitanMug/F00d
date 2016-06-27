package com.humanbooster.f00d.anderson.service;

import java.util.List;

import com.humanbooster.f00d.anderson.business.Restaurant;

public interface RestaurantService {

	public List<Restaurant> targetRestaurant();

	public void CreateRestaurant(String nom, String description, String addressL1, String addressL2, String codePostal);

	public Restaurant targetRestaurantByd(int idRest);

}
