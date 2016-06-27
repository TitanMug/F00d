package com.humanbooster.f00d.anderson.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.humanbooster.f00d.anderson.business.Element;
import com.humanbooster.f00d.anderson.dao.ElementDao;
import com.humanbooster.f00d.anderson.service.ElementService;

@Service
public class ElementServiceImpl implements ElementService {
	@Autowired
	private ElementDao service;

	@Override
	public List<Element> targetElement() {
		return service.findAll();
	}

	@Override
	public void CreateElement(String libelle, String description, float prix) {
		service.create(new Element(libelle, description, prix));
	}

	@Override
	public List<Element> targetElementByCatAndRest(int idRest, int idCat) {
		return service.findAllByCatAndRest(idRest, idCat);
	}

	@Override
	public List<Element> targetElementByIdrest(int idRest) {
		return service.findAllByRest(idRest);
	}

	@Override
	public Element targetElementById(int idElem) {
		return service.findById(idElem);
	}

}
