package com.humanbooster.f00d.anderson.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.humanbooster.f00d.anderson.business.Element;
import com.humanbooster.f00d.anderson.dao.ElementDao;

@Repository
public class ElementDaoImpl implements ElementDao {
	@Autowired
	private SessionFactory sf;

	public ElementDaoImpl() {
		super();
	}

	public ElementDaoImpl(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Transactional
	@Override
	public boolean create(Element Element) {
		System.out.print("Create Element: ");
		sf.getCurrentSession().save(Element);
		System.out.println("");
		return true;
	}

	@Transactional
	@Override
	public boolean update(Element Element) {
		System.out.print("Update Element: ");
		sf.getCurrentSession().update(Element);
		System.out.println("");
		return false;
	}

	@Transactional
	@Override
	public boolean delete(Element Element) {
		System.out.print("Delete Element: ");
		sf.getCurrentSession().delete(Element);
		System.out.println("");
		return false;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Element> findAll() {
		System.out.print("Find All Element: ");
		return sf.getCurrentSession().createQuery("FROM Element").list();

	}

	@Transactional(readOnly = true)
	@Override
	public Element findById(int idElem) {
		System.out.print("Find All Element: ");
		return (Element) sf.getCurrentSession().createQuery("FROM Element WHERE idElem =:id").setInteger("id", idElem)
				.uniqueResult();
	}

	@Transactional
	@Override
	public List<Element> findAllByCatAndRest(int idRest, int idCat) {
		return sf.getCurrentSession().createQuery("FROM Element WHERE ").list();
	}

	@Transactional
	@Override
	public List<Element> findAllByRest(int idRest) {
		return sf.getCurrentSession().createQuery("FROM Element WHERE idRest =:id").setInteger("id", idRest).list();
	}

}
