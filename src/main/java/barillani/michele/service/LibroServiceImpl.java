package barillani.michele.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.web.multipart.MultipartFile;

import barillani.michele.dao.LibroDao;
import barillani.michele.model.Autore;
import barillani.michele.model.Categoria;
import barillani.michele.model.Libro;

@Service
public class LibroServiceImpl implements LibroService
{
	@Autowired
	private LibroDao libroDao;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private AutoreService autoreService;

	@Override
	public void registraLibro(Libro libro, Object... dati)
	{
		libro.setTitolo((String) dati[0]);
		libro.setTrama((String) dati[1]);
		MultipartFile copertina = (MultipartFile) dati[2];
		int idCategoria = (int) dati[3];
		int idAutore = (int) dati[4];
		
		if(copertina != null && !copertina.isEmpty())
			try
			{
				libro.setCopertina("data:image/png;base64," + Base64Utils.encodeToString(copertina.getBytes()));
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		Categoria categoria = categoriaService.getCategoriaById(idCategoria);
		libro.setCategoria(categoria);
		Autore autore = autoreService.getAutoreById(idAutore);
		libro.setAutore(autore);
		
		libroDao.save(libro);
	}

	@Override
	public Libro getLibroById(int id)
	{
		return libroDao.findById(id).get();
	}

	@Override
	public List<Libro> getLibri()
	{
		return (List<Libro>) libroDao.findAll();
	}

	@Override
	public void cancellaLibro(Libro libro)
	{				
		libroDao.delete(libro);
	}

}
