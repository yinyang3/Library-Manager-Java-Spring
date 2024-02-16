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

import barillani.michele.model.Categoria;
import barillani.michele.service.CategoriaService;

@Controller
@RequestMapping("/aggiungicategorie")
public class AggiungiCategorieController
{
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public String getPage(Model model, @RequestParam(name = "id", required = false) Integer id) 
	{
	    Categoria categoria = id == null ? new Categoria() : categoriaService.getCategoriaById(id);
		model.addAttribute("categoria", categoria);
		return "aggiungicategorie";
	}
	
	@PostMapping
	public String registraCategoria(@Valid @ModelAttribute("categoria") Categoria categoria, BindingResult result)
	{
		if (result.hasErrors())
			return "aggiungicategorie";
		categoriaService.registraCategoria(categoria);
		return "redirect:/categorie";
	}
}
