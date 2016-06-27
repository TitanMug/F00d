package com.humanbooster.f00d.anderson.business;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idrest")
	private int idRest;
	@Column(unique = true)
	private String nom;
	@Column(length = 100)
	private String description;
	private String addressL1;
	private String addressL2;
	private String codePostal;

	@OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
	private List<Commande> commandes;

	@OneToMany(mappedBy = "restaurant", fetch = FetchType.EAGER)
	private List<Element> elements;

	public List<Commande> getCommandes() {
		return commandes;
	}

	public Restaurant() {
		super();
	}

	public Restaurant(String nom, String description, String addressL1, String addressL2, String codePostal) {
		super();
		this.nom = nom;
		this.description = description;
		this.addressL1 = addressL1;
		this.addressL2 = addressL2;
		this.codePostal = codePostal;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public int getIdRest() {
		return idRest;
	}

	public void setIdRest(int idRest) {
		this.idRest = idRest;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddressL1() {
		return addressL1;
	}

	public void setAddressL1(String addressL1) {
		this.addressL1 = addressL1;
	}

	public String getAddressL2() {
		return addressL2;
	}

	public void setAddressL2(String addressL2) {
		this.addressL2 = addressL2;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public List<Element> getElements() {
		return elements;
	}

	public void setElements(List<Element> elements) {
		this.elements = elements;
	}

}
