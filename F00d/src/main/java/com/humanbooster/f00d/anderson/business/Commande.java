package com.humanbooster.f00d.anderson.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "commande")
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCom")
	private int idCom;

	@ManyToOne
	@JoinColumn(name = "idUtil")
	private Utilisateur utilisateur;
	@ManyToOne
	@JoinColumn(name = "idRest")
	private Restaurant restaurant;
	@ManyToOne
	@JoinColumn(name = "idElem")
	private Element element;

	public Commande() {
		super();
	}

	public Commande(Utilisateur utilisateur, Restaurant restaurant, Element element) {
		super();
		this.utilisateur = utilisateur;
		this.restaurant = restaurant;
		this.element = element;

	}

	public Element getElement() {
		return element;
	}

	public void setElement(Element element) {
		this.element = element;
	}

	public int getIdCom() {
		return idCom;
	}

	public void setIdCom(int idCom) {
		this.idCom = idCom;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
