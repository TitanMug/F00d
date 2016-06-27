package com.humanbooster.f00d.anderson.service;

import java.util.List;

import com.humanbooster.f00d.anderson.business.Commande;
import com.humanbooster.f00d.anderson.business.Element;
import com.humanbooster.f00d.anderson.business.Restaurant;
import com.humanbooster.f00d.anderson.business.Utilisateur;

public interface CommandeService {

	public List<Commande> targetCommande();

	public void CreateCommande(Utilisateur utilisateur, Restaurant restaurant, Element element);

	public List<Commande> targetCommandeCommand(int idRest, int idUtil);

	public void deleteCommande(int idCom);
}
