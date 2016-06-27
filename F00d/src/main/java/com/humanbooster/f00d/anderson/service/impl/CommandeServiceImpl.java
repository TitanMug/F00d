package com.humanbooster.f00d.anderson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.f00d.anderson.business.Commande;
import com.humanbooster.f00d.anderson.business.Element;
import com.humanbooster.f00d.anderson.business.Restaurant;
import com.humanbooster.f00d.anderson.business.Utilisateur;
import com.humanbooster.f00d.anderson.dao.CommandeDao;
import com.humanbooster.f00d.anderson.service.CommandeService;

@Service
public class CommandeServiceImpl implements CommandeService {
	@Autowired
	private CommandeDao service;

	@Override
	public List<Commande> targetCommande() {
		return service.findAll();
	}

	@Override
	public void CreateCommande(Utilisateur utilisateur, Restaurant restaurant, Element element) {
		service.create(new Commande(utilisateur, restaurant, element));

	}

	@Override
	public List<Commande> targetCommandeCommand(int idRest, int idUtil) {
		return service.findAllCommand(idRest, idUtil);
	}

	@Override
	public void deleteCommande(int idCom) {
		Commande commande = service.findById(idCom);
		service.delete(commande);

	}

}
