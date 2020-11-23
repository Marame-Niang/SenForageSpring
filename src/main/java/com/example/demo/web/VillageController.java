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

import com.example.demo.dao.VillageRepository;
import com.example.demo.entities.Village;

@Controller
public class VillageController {
	@Autowired
	private VillageRepository villageRepository;
	
	@RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/ajoutVillage", method = RequestMethod.GET)
	public String ajoutVillage(Model model) {
		model.addAttribute("village", new Village());
		return "village/ajout";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Model model, @Validated Village village, BindingResult bindingResult) {
		if(bindingResult.hasErrors())
			return "village/ajout";
		model.addAttribute("village", new Village());
		villageRepository.save(village);
		return "redirect:/listeVillage";
	}
	
	@RequestMapping(value = "/listeVillage")
	public String village(ModelMap model) {
		List<Village> villages=villageRepository.findAll();
		model.addAttribute("listeVillage", villages);
		model.put("village", new Village());
		return "village/liste"; 
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(int id, ModelMap model) {  	
		Village village = villageRepository.getOne(id);
		model.put("village", village);
		return "village/ajout";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(int id) {
		villageRepository.deleteById(id);
		return "redirect:/listeVillage";
	}
}
