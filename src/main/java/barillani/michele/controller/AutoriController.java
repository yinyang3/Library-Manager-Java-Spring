package barillani.michele.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import barillani.michele.model.Autore;
import barillani.michele.service.AutoreService;

@Controller
@RequestMapping("/autori")
public class AutoriController
{
	@Autowired
	private AutoreService autoreService;
	
	@GetMapping
	public String getPage(Model model) 
	{
		model.addAttribute("autori", autoreService.getAutori());
		model.addAttribute("autore", new Autore());
		return "autori";
	}

	@GetMapping("/cancellaautore")
	public String cancellaAutore(@RequestParam("id") int id) 
	{
		Autore autore = autoreService.getAutoreById(id);
		autoreService.cancellaAutore(autore); 
		return "redirect:/autori";
	}
}
