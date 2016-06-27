package com.humanbooster.f00d.anderson.service;

import java.util.List;

import com.humanbooster.f00d.anderson.business.Utilisateur;

public interface UtilisateurService {

	public List<Utilisateur> targetUtilisateur();

	public void CreateUtilisateur(String adress, String noCarte, String dateExp, String crypt);

	public Utilisateur targetUtilisateur(int idUti);

}
