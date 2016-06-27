package com.humanbooster.f00d.anderson.dao;

import java.util.List;

import com.humanbooster.f00d.anderson.business.Utilisateur;

public interface UtilisateurDao {
	// Create
	public boolean create(Utilisateur utilisateur);

	// update
	public boolean update(Utilisateur utilisateur);

	// delete
	public boolean delete(Utilisateur utilisateur);

	// read
	public List<Utilisateur> findAll();

	// read
	public Utilisateur findById(int idUtil);
}
