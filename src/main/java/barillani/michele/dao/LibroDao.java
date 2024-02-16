package barillani.michele.dao;

import org.springframework.data.repository.CrudRepository;

import barillani.michele.model.Libro;

public interface LibroDao extends CrudRepository<Libro, Integer>
{

}
