package barillani.michele.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import barillani.michele.dao.AutoreDao;
import barillani.michele.model.Autore;

@Service
public class AutoreServiceImpl implements AutoreService
{
	@Autowired
	private AutoreDao autoreDao;
	
	@Override
	public void registraAutore(Autore autore)
	{
		autoreDao.save(autore);
	}

	@Override
	public Autore getAutoreById(int id)
	{
		return autoreDao.findById(id).get();
	}

	@Override
	public List<Autore> getAutori()
	{
		return (List<Autore>) autoreDao.findAll();
	}

	@Override
	public void cancellaAutore(Autore autore)
	{
		autoreDao.delete(autore);
	}

}
