package com.humanbooster.f00d.anderson.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.humanbooster.f00d.anderson.business.Commande;
import com.humanbooster.f00d.anderson.business.Element;
import com.humanbooster.f00d.anderson.business.Restaurant;
import com.humanbooster.f00d.anderson.business.Utilisateur;
import com.humanbooster.f00d.anderson.service.CategorieService;
import com.humanbooster.f00d.anderson.service.CommandeService;
import com.humanbooster.f00d.anderson.service.ElementService;
import com.humanbooster.f00d.anderson.service.RestaurantService;
import com.humanbooster.f00d.anderson.service.UtilisateurService;

@Controller
public class RestaurautionController {

	@Autowired
	private RestaurantService rS;
	@Autowired
	private CategorieService cS;
	@Autowired
	private ElementService eS;
	@Autowired
	private CommandeService cmS;
	@Autowired
	private UtilisateurService uS;

	@RequestMapping(value = "/")
	public String vide(Map<String, Object> map) {
		System.out.println("Vide");
		return indexGet(map);
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexGet(Map<String, Object> map) {
		System.out.println("Accueil");
		List<Restaurant> lR = rS.targetRestaurant();
		map.put("restaurants", lR);
		return "index";

	}

	@RequestMapping(value = "/commande", method = RequestMethod.POST)
	public String commandePost(Map<String, Object> map, @RequestParam String idRest, @RequestParam String idUti) {
		Restaurant R = rS.targetRestaurantByd(Integer.parseInt(idRest));
		Utilisateur U = uS.targetUtilisateur(Integer.parseInt(idUti));
		List<Commande> lCM = cmS.targetCommandeCommand(R.getIdRest(), U.getIdUti());
		map.put("restaurant", R);
		map.put("elements", eS.targetElementByIdrest(R.getIdRest()));
		map.put("commandes", lCM);

		return "commande";
	}

	@RequestMapping(value = "/Add", method = RequestMethod.POST)
	// Ici rajouter @RequestParam String idUti quand on aura cree un
	// utilisateur complete
	public String addPost(Map<String, Object> map, @RequestParam String idRest, @RequestParam String idElem,
			@RequestParam String idUti) {
		Restaurant R = rS.targetRestaurantByd(Integer.parseInt(idRest));
		Element E = eS.targetElementById(Integer.parseInt(idElem));
		Utilisateur U = uS.targetUtilisateur(Integer.parseInt(idUti));
		cmS.CreateCommande(U, R, E);
		List<Commande> lCM = cmS.targetCommandeCommand(R.getIdRest(), U.getIdUti());
		map.put("commandes", lCM);

		map.put("restaurant", R);
		map.put("elements", eS.targetElementByIdrest(R.getIdRest()));
		return commandePost(map, idRest, idUti);
	}

	@RequestMapping(value = "/supp", method = RequestMethod.POST)
	public String SuppCommand(Map<String, Object> map, @RequestParam String idCom, @RequestParam String idRest,
			@RequestParam String idUti) {
		System.out.println(idCom);
		System.out.println(idRest);
		cmS.deleteCommande(Integer.parseInt(idCom));
		return commandePost(map, idRest, idUti);
	}

	@RequestMapping(value = "/paiement", method = RequestMethod.POST)
	public String paiementPost(Map<String, Object> map, @RequestParam String idRest, @RequestParam String idUti) {

		Restaurant R = rS.targetRestaurantByd(Integer.parseInt(idRest));
		Utilisateur U = uS.targetUtilisateur(Integer.parseInt(idUti));

		List<Commande> lCM = cmS.targetCommandeCommand(R.getIdRest(), U.getIdUti());
		map.put("commandes", lCM);

		return "paiement";
	}

	@RequestMapping(value = "/final", method = RequestMethod.POST)
	public String finalPost(Map<String, Object> map, @RequestParam String idUti, @RequestParam String noCart,
			@RequestParam String dateExp, @RequestParam String crypt) {

		Utilisateur U = uS.targetUtilisateur(Integer.parseInt(idUti));
		// int noCarte = Integer.parseInt(noCart);
		// int noCrypte = Integer.parseInt(crypt);

		if (noCart.equals(U.getNoCarte()) && dateExp.equals(U.getDateExp()) && crypt.equals(U.getCrypt()))
			return "final";
		return "paiement";
	}

}
