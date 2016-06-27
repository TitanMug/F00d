package com.humanbooster.f00d.anderson.service;

import java.util.List;

import com.humanbooster.f00d.anderson.business.Categorie;

public interface CategorieService {

	public List<Categorie> targetCategorie();

	public void CreateCategorie(String nom);

	public Categorie targetCategorieById(int id);

}
