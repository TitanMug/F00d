package com.humanbooster.f00d.anderson.business;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "element")
public class Element {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idElem")
	private int idElem;

	private String libelle;
	private String description;
	private double prix;

	@OneToOne
	@JoinColumn(name = "idCat")
	private Categorie categorie;

	@ManyToOne()
	@JoinColumn(name = "idRest")
	private Restaurant restaurant;

	@OneToMany(mappedBy = "element", fetch = FetchType.EAGER)
	private List<Commande> elements;

	public Element() {
		super();
	}

	public Element(String libelle, String description, float prix) {
		super();
		this.libelle = libelle;
		this.description = description;
		this.prix = prix;

	}

	public List<Commande> getElements() {
		return elements;
	}

	public void setElements(List<Commande> elements) {
		this.elements = elements;
	}

	public int getIdElem() {
		return idElem;
	}

	public void setIdElem(int idElem) {
		this.idElem = idElem;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

}
