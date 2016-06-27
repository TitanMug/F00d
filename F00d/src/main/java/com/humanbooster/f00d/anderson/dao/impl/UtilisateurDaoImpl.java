package com.humanbooster.f00d.anderson.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.humanbooster.f00d.anderson.business.Utilisateur;
import com.humanbooster.f00d.anderson.dao.UtilisateurDao;

@Repository
public class UtilisateurDaoImpl implements UtilisateurDao {

	@Autowired
	private SessionFactory sf;

	public UtilisateurDaoImpl() {
		super();
	}

	public UtilisateurDaoImpl(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Transactional
	@Override
	public boolean create(Utilisateur Utilisateur) {
		System.out.print("Create Utilisateur: ");
		sf.getCurrentSession().save(Utilisateur);
		System.out.println("");
		return true;
	}

	@Transactional
	@Override
	public boolean update(Utilisateur Utilisateur) {
		System.out.print("Update Utilisateur: ");
		sf.getCurrentSession().update(Utilisateur);
		System.out.println("");
		return false;
	}

	@Transactional
	@Override
	public boolean delete(Utilisateur Utilisateur) {
		System.out.print("Delete Utilisateur: ");
		sf.getCurrentSession().delete(Utilisateur);
		System.out.println("");
		return false;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Utilisateur> findAll() {
		System.out.print("Find All Utilisateur: ");
		return sf.getCurrentSession().createQuery("FROM Utilisateur").list();

	}

	@Transactional(readOnly = true)
	@Override
	public Utilisateur findById(int idUti) {
		System.out.print("Find All Utilisateur: ");
		return (Utilisateur) sf.getCurrentSession().createQuery("FROM Utilisateur WHERE idUti =:id")
				.setInteger("id", idUti).uniqueResult();
	}

}
