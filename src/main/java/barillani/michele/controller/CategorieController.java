package barillani.michele.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import barillani.michele.model.Categoria;
import barillani.michele.service.CategoriaService;

@Controller
@RequestMapping("/categorie")
public class CategorieController
{
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public String getPage(Model model) 
	{
		model.addAttribute("categorie", categoriaService.getCategorie());
		model.addAttribute("categoria", new Categoria());
		return "categorie";
	}

	@GetMapping("/cancellacategoria")
	public String cancellaCategoria(@RequestParam("id") int id) 
	{
		Categoria categoria = categoriaService.getCategoriaById(id);
		categoriaService.cancellaCategoria(categoria); 
		return "redirect:/categorie";
	}
}
