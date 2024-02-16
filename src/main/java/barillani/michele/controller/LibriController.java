package barillani.michele.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import barillani.michele.model.Libro;
import barillani.michele.service.LibroService;

@Controller
@RequestMapping("/libri")
public class LibriController
{
	@Autowired
	LibroService libroService;
	
	@GetMapping
	public String getPage(Model model)
	{
		List<Libro> libri = libroService.getLibri();
		model.addAttribute("libri", libri);
		return "libri";
	}
	
	@GetMapping("/cancellalibro")
	public String cancellaLibro(@RequestParam("id") int id) 
	{
		Libro libro = libroService.getLibroById(id);
		libroService.cancellaLibro(libro); 
		return "redirect:/libri";
	}
	
}
