package com.humanbooster.f00d.anderson.service;

import java.util.List;

import com.humanbooster.f00d.anderson.business.Element;

public interface ElementService {

	public List<Element> targetElement();

	public void CreateElement(String libelle, String description, float prix);

	public List<Element> targetElementByCatAndRest(int idRest, int idCat);

	public List<Element> targetElementByIdrest(int idRest);

	public Element targetElementById(int idElem);

}
