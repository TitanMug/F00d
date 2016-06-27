package com.humanbooster.f00d.anderson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.f00d.anderson.business.Categorie;
import com.humanbooster.f00d.anderson.dao.CategorieDao;
import com.humanbooster.f00d.anderson.service.CategorieService;

@Service
public class CategorieServiceImpl implements CategorieService {
	@Autowired
	private CategorieDao service;

	@Override
	public List<Categorie> targetCategorie() {
		return service.findAll();
	}

	@Override
	public void CreateCategorie(String nom) {
		service.create(new Categorie(nom));

	}

	@Override
	public Categorie targetCategorieById(int id) {
		return service.findById(id);
	}

}
