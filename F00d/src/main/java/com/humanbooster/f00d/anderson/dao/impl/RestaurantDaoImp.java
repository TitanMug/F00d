package com.humanbooster.f00d.anderson.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.humanbooster.f00d.anderson.business.Restaurant;
import com.humanbooster.f00d.anderson.dao.RestaurantDao;

@Repository
public class RestaurantDaoImp implements RestaurantDao {

	@Autowired
	private SessionFactory sf;

	public RestaurantDaoImp() {
		super();
	}

	public RestaurantDaoImp(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Transactional
	@Override
	public boolean create(Restaurant restaurant) {
		System.out.print("Create Restaurant: ");
		sf.getCurrentSession().save(restaurant);
		System.out.println("");
		return true;
	}

	@Transactional
	@Override
	public boolean update(Restaurant restaurant) {
		System.out.print("Update Restaurant: ");
		sf.getCurrentSession().update(restaurant);
		System.out.println("");
		return false;
	}

	@Transactional
	@Override
	public boolean delete(Restaurant restaurant) {
		System.out.print("Delete Restaurant: ");
		sf.getCurrentSession().delete(restaurant);
		System.out.println("");
		return false;
	}

	@Transactional(readOnly = true)
	@Override
	public List<Restaurant> findAll() {
		System.out.print("Find All Restaurant: ");
		return sf.getCurrentSession().createQuery("FROM Restaurant").list();

	}

	@Transactional(readOnly = true)
	@Override
	public Restaurant findById(int idRest) {
		System.out.print("Find All Restaurant: ");
		return (Restaurant) sf.getCurrentSession().createQuery("FROM Restaurant WHERE idRest =:id")
				.setInteger("id", idRest).uniqueResult();
	}

}
