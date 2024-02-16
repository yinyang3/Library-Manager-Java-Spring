package barillani.michele.service;

import java.util.List;

import barillani.michele.model.Autore;

public interface AutoreService
{
	void registraAutore(Autore autore);
	Autore getAutoreById(int id);
	List<Autore> getAutori();
	void cancellaAutore(Autore autore);
}
