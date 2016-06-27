package com.humanbooster.f00d.anderson.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.humanbooster.f00d.anderson.business.Categorie;
import com.humanbooster.f00d.anderson.dao.CategorieDao;

@Repository
public class CategorieDaoImpl implements CategorieDao {
	@Autowired
	private SessionFactory sf;

	public CategorieDaoImpl() {
		super();
	}

	public CategorieDaoImpl(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Transactional
	@Override
	public boolean create(Categorie Categorie) {
		System.out.print("Create Categorie: ");
		sf.getCurrentSession().save(Categorie);
		System.out.println("");
		return true;
	}

	@Transactional
	@Override
	public boolean update(Categorie Categorie) {
		System.out.print("Update Categorie: ");
		sf.getCurrentSession().update(Categorie);
		System.out.println("");
		return false;
	}

	@Transactional
	@Override
	public boolean delete(Categorie Categorie) {
		System.out.print("Delete Categorie: ");
		sf.getCurrentSession().delete(Categorie);
		System.out.println("");
		return false;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Categorie> findAll() {
		System.out.print("Find All Categorie: ");
		return sf.getCurrentSession().createQuery("FROM Categorie").list();

	}

	@Transactional(readOnly = true)
	@Override
	public Categorie findById(int idCat) {
		System.out.print("Find All Categorie: ");
		return (Categorie) sf.getCurrentSession().createQuery("FROM Categorie WHERE idCat =:id").setInteger("id", idCat)
				.uniqueResult();
	}

}
