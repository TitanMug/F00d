package com.humanbooster.f00d.anderson.dao;

import java.util.List;

import com.humanbooster.f00d.anderson.business.Restaurant;

public interface RestaurantDao {
	// Create
	public boolean create(Restaurant restaurant);

	// update
	public boolean update(Restaurant restaurant);

	// delete
	public boolean delete(Restaurant restaurant);

	// read
	public List<Restaurant> findAll();

	// read
	public Restaurant findById(int idRest);

}
