package barillani.michele.service;

import java.util.List;

import barillani.michele.model.Libro;

public interface LibroService
{
	void registraLibro (Libro libro, Object... dati);
	Libro getLibroById(int id);
	List<Libro> getLibri();
	void cancellaLibro(Libro libro);
}
