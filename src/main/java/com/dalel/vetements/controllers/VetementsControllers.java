package com.dalel.vetements.controllers;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dalel.vetements.entities.Vetement;
import com.dalel.vetements.service.VetementService;

@Controller
public class VetementsControllers {

	@Autowired
	VetementService vetementService;
	@RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createVetement";
	}
	@RequestMapping("/saveVetement")
	public String saveVetement(@ModelAttribute("Vetement") Vetement vetement, 
	 @RequestParam("date") String date,
	 ModelMap modelMap) throws ParseException 
	{
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateprod = dateformat.parse(String.valueOf(date));
	 vetement.setDateprod(dateprod);
	 
	 Vetement saveVetement = vetementService.saveVetement(vetement);
	String msg ="Vetement enregistré avec Id "+saveVetement.getIdvetement();
	modelMap.addAttribute("msg", msg);
	return "createVetement";
	}
	@RequestMapping("/ListeVetements")
	public String listeVetement(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)

	{
	Page<Vetement> vet= vetementService.getAllVetementParPage(page,size);
	modelMap.addAttribute("vetements", vet);
	modelMap.addAttribute("pages", new int[vet.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	return "ListeVetements";
	}
	@RequestMapping("/supprimervetement")
	public String supprimerVetement(@RequestParam("id") Long id,
	 ModelMap modelMap,
	 @RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "2") int size)

	{ 
	vetementService.deleteVetementById(id);
	Page<Vetement> p = vetementService.getAllVetementParPage(page,size);
	modelMap.addAttribute("vetements", p);
	modelMap.addAttribute("pages", new int[p.getTotalPages()]);
	modelMap.addAttribute("currentPage", page);
	modelMap.addAttribute("size", size);
	return "ListeVetements";
	}
	@RequestMapping("/modifiervetement")
	public String editerVetement(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Vetement p= vetementService.getVetement(id);
	modelMap.addAttribute("vetements", p);
	return "editerVetement";
	}
	@RequestMapping("/updateVetement")
	public String updateVetement(@ModelAttribute("vetement")Vetement vetement,
	@RequestParam("date") String date,
	 ModelMap modelMap) throws ParseException 
	{
	//conversion de la date 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 vetement.setDateprod(dateCreation);
	 
	 vetementService.updateVetement(vetement);
	 List<Vetement> prods = vetementService.getAllVetement();
	 modelMap.addAttribute("vetements", prods);
	return "ListeVetements";
	}

	
	
}
