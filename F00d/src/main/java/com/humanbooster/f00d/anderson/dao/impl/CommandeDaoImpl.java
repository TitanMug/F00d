package com.humanbooster.f00d.anderson.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.humanbooster.f00d.anderson.business.Commande;
import com.humanbooster.f00d.anderson.dao.CommandeDao;

@Repository
public class CommandeDaoImpl implements CommandeDao {
	@Autowired
	private SessionFactory sf;

	public CommandeDaoImpl() {
		super();
	}

	public CommandeDaoImpl(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Transactional
	@Override
	public boolean create(Commande Commande) {
		System.out.print("Create Commande: ");
		sf.getCurrentSession().save(Commande);
		System.out.println("");
		return true;
	}

	@Transactional
	@Override
	public boolean update(Commande Commande) {
		System.out.print("Update Commande: ");
		sf.getCurrentSession().update(Commande);
		System.out.println("");
		return false;
	}

	@Transactional
	@Override
	public boolean delete(Commande Commande) {
		System.out.print("Delete Commande: ");
		sf.getCurrentSession().delete(Commande);
		System.out.println("");
		return false;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Commande> findAll() {
		System.out.print("Find All Commande: ");
		return sf.getCurrentSession().createQuery("FROM Commande").list();

	}

	@Transactional(readOnly = true)
	@Override
	public Commande findById(int idCom) {
		System.out.print("Find All Commande: ");
		return (Commande) sf.getCurrentSession().createQuery("FROM Commande WHERE idCom =:id").setInteger("id", idCom)
				.uniqueResult();
	}

	@Transactional
	@Override
	public List<Commande> findAllCommand(int idRest, int idUtil) {
		System.out.print("Find All By Restaurant And Utilisateur Commande : ");
		return sf.getCurrentSession().createQuery("FROM Commande where idRest=:idRest and idUtil=:idUtil")
				.setInteger("idRest", idRest).setInteger("idUtil", idUtil).list();
	}

}
