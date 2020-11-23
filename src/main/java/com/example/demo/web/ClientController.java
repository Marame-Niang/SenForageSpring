package com.example.demo.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.example.demo.dao.ClientRepository;

import com.example.demo.dao.VillageRepository;
import com.example.demo.entities.Client;
import com.example.demo.entities.Village;

@Controller
public class ClientController {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private VillageRepository villageRepository;
	
	@RequestMapping(value = "/ajoutClient", method = RequestMethod.GET)
	public String ajoutClient(ModelMap model) {
		model.addAttribute("client", new Client());
		List<Village> villages = villageRepository.findAll();
		model.put("liste_village", villages);
		return "client/ajout";
	}
	
	@RequestMapping(value = "/enregistrer", method = RequestMethod.POST)
	public String save(Model model, @Validated Client client, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "client/ajout";
		model.addAttribute("client", new Client());
		clientRepository.save(client);
		return "redirect:/listeClient`";
	}
	
	@RequestMapping(value = "/listeClient")
	public String client(ModelMap model) {
		List<Client> clients = clientRepository.findAll();
		model.addAttribute("listeClient", clients);
		model.put("client", new Client());
		return "client/liste"; 
	}
	
	@RequestMapping(value = "/supprimer")
	public String supprimer(int id) {
		clientRepository.deleteById(id);
		return "redirect:/listeClient";
	}
	
	@RequestMapping(value = "/editer", method = RequestMethod.GET)
	public String editer(int id, ModelMap model) {  
		List<Village> villages = villageRepository.findAll();
		model.put("liste_village", villages);
		
		Client client = clientRepository.getOne(id);
		model.put("client", client);
		return "client/ajout";
	}
}
