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
@Table(name = "autori")
public class Autore
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Pattern(regexp="[a-zA-Z\\s'.èéàòìùÈÉÀÒÌÙ]{1,255}", message = "Caratteri non ammessi")
	@Column(name = "nome")
	private String nome;
	
	@Pattern(regexp="[a-zA-Z\\s'.èéàòìùÈÉÀÒÌÙ]{1,255}", message = "Caratteri non ammessi")
	@Column(name = "cognome")
	private String cognome;
	
	@OneToMany
	(
			mappedBy = "autore",
			cascade = CascadeType.REFRESH,
			fetch = FetchType.EAGER,
			orphanRemoval = true
	)
	private List<Libro> libri = new ArrayList<>();
	
	@Transient
	private boolean incluso;

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

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getCognome()
	{
		return cognome;
	}

	public void setCognome(String cognome)
	{
		this.cognome = cognome;
	}
	
}
