package barillani.michele.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "categorie")
public class Categoria
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Pattern(regexp="[a-zA-Z\\\\s',èéàòìùÈÉÀÒÌÙ]{1,255}", message = "Caratteri non ammessi")
	@Column(name = "descrizione")
	private String descrizione;
	
	@OneToMany
	(
			mappedBy = "categoria",
			cascade = CascadeType.REFRESH,
			fetch = FetchType.EAGER,
			orphanRemoval = true
	)
	private List<Libro> libri = new ArrayList<>();
	
	@Transient
	private boolean incluso;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getDescrizione()
	{
		return descrizione;
	}

	public void setDescrizione(String descrizione)
	{
		this.descrizione = descrizione;
	}

	public List<Libro> getLibri()
	{
		return libri;
	}

	public void setLibri(List<Libro> libri)
	{
		this.libri = libri;
	}

	public boolean isIncluso()
	{
		return incluso;
	}

	public void setIncluso(boolean incluso)
	{
		this.incluso = incluso;
	}
	
}
