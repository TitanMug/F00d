package com.humanbooster.f00d.anderson.dao;

import java.util.List;

import com.humanbooster.f00d.anderson.business.Categorie;

public interface CategorieDao {
	// Create
	public boolean create(Categorie categorie);

	// update
	public boolean update(Categorie categorie);

	// delete
	public boolean delete(Categorie categorie);

	// read
	public List<Categorie> findAll();

	// read
	public Categorie findById(int idCat);
}
