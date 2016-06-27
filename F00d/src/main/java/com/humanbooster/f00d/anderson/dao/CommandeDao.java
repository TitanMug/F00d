package com.humanbooster.f00d.anderson.dao;

import java.util.List;

import com.humanbooster.f00d.anderson.business.Commande;

public interface CommandeDao {
	// Create
	public boolean create(Commande commande);

	// update
	public boolean update(Commande commande);

	// delete
	public boolean delete(Commande commande);

	// read
	public List<Commande> findAll();

	// read
	public Commande findById(int idCom);

	// read
	public List<Commande> findAllCommand(int idRest, int idUtil);
}
