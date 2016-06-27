package com.humanbooster.f00d.anderson.business;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUti")
	private int idUti;

	private String adress;
	private String noCarte;
	private String dateExp;
	private String crypt;
	@OneToMany(mappedBy = "restaurant")
	private List<Commande> commandes;

	public Utilisateur() {
		super();
	}

	public Utilisateur(String adress, String noCarte, String dateExp, String crypt) {
		super();
		this.adress = adress;
		this.noCarte = noCarte;
		this.dateExp = dateExp;
		this.crypt = crypt;
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public int getIdUti() {
		return idUti;
	}

	public void setIdUti(int idUti) {
		this.idUti = idUti;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getNoCarte() {
		return noCarte;
	}

	public void setNoCarte(String noCarte) {
		this.noCarte = noCarte;
	}

	public String getDateExp() {
		return dateExp;
	}

	public void setDateExp(String dateExp) {
		this.dateExp = dateExp;
	}

	public String getCrypt() {
		return crypt;
	}

	public void setCrypt(String crypt) {
		this.crypt = crypt;
	}

}
