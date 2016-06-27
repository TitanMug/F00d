package com.humanbooster.f00d.anderson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.f00d.anderson.business.Utilisateur;
import com.humanbooster.f00d.anderson.dao.UtilisateurDao;
import com.humanbooster.f00d.anderson.service.UtilisateurService;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
	@Autowired
	private UtilisateurDao service;

	@Override
	public List<Utilisateur> targetUtilisateur() {
		return service.findAll();
	}

	@Override
	public void CreateUtilisateur(String adress, String noCarte, String dateExp, String crypt) {
		service.create(new Utilisateur(adress, noCarte, dateExp, crypt));
	}

	@Override
	public Utilisateur targetUtilisateur(int idUti) {
		return service.findById(idUti);

	}

}
