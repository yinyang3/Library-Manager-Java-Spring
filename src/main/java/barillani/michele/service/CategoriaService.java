package barillani.michele.service;

import java.util.List;

import barillani.michele.model.Categoria;

public interface CategoriaService
{
	void registraCategoria(Categoria categoria);
	Categoria getCategoriaById(int id);
	List<Categoria> getCategorie();
	void cancellaCategoria(Categoria categoria);
}
