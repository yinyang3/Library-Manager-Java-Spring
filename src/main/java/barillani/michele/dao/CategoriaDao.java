package barillani.michele.dao;

import org.springframework.data.repository.CrudRepository;

import barillani.michele.model.Categoria;

public interface CategoriaDao extends CrudRepository<Categoria, Integer>
{

}
