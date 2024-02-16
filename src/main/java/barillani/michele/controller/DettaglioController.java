package barillani.michele.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import barillani.michele.model.Autore;
import barillani.michele.model.Categoria;
import barillani.michele.model.Libro;
import barillani.michele.service.AutoreService;
import barillani.michele.service.CategoriaService;
import barillani.michele.service.LibroService;

@Controller
@RequestMapping("/dettaglio")
public class DettaglioController
{
	@Autowired
	private LibroService libroService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private AutoreService autoreService;
	
	private Libro libro;
	
	@GetMapping
	public String getPage(Model model, @RequestParam(name = "id", required = false) Integer id) 
	{
		libro = id == null ? new Libro() : libroService.getLibroById(id);
		List<Categoria> categorie = categoriaService.getCategorie();
		List<Autore> autori = autoreService.getAutori();
		if(id != null)
			for(Categoria c : categorie)
				for(Categoria cInCategoria : categoriaService.getCategorie())
					if(c.getId() == cInCategoria.getId())
						c.setIncluso(true);
		if(id != null)
			for(Autore a : autori)
				for(Autore aInAutore : autoreService.getAutori())
					if(a.getId() == aInAutore.getId())
						a.setIncluso(true);
		model.addAttribute("libri", libroService.getLibri());
		model.addAttribute("categorie", categorie);
		model.addAttribute("autori", autori);
		model.addAttribute("libro", libro);
		return "dettaglio";
	}
	
}
