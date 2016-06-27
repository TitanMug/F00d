package com.humanbooster.f00d.anderson.dao;

import java.util.List;

import com.humanbooster.f00d.anderson.business.Element;

public interface ElementDao {
	// Create
	public boolean create(Element element);

	// update
	public boolean update(Element element);

	// delete
	public boolean delete(Element element);

	// read
	public List<Element> findAll();

	// read
	public Element findById(int idElem);

	// read
	public List<Element> findAllByCatAndRest(int idRest, int idCat);

	public List<Element> findAllByRest(int idRest);
}
