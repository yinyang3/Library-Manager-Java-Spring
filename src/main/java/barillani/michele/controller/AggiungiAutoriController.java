package barillani.michele.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import barillani.michele.model.Autore;
import barillani.michele.service.AutoreService;

@Controller
@RequestMapping("/aggiungiautori")
public class AggiungiAutoriController
{
	@Autowired
	AutoreService autoreService;
	
	@GetMapping
	public String getPage(Model model, @RequestParam(name = "id", required = false) Integer id) 
	{
	    Autore autore = id == null ? new Autore() : autoreService.getAutoreById(id);
		model.addAttribute("autore", autore);
		return "aggiungiautori";
	}
	
	@PostMapping
	public String registraAutore(@Valid @ModelAttribute("autore") Autore autore, BindingResult result)
	{
		if (result.hasErrors())
			return "aggiungiautori";
		autoreService.registraAutore(autore);
		return "redirect:/autori";
	}
}
