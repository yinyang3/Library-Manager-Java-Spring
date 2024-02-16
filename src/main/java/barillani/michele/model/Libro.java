package barillani.michele.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "libri")
public class Libro
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "titolo")
	private String titolo;
	
	@Column(name = "trama")
	private String trama;
	
	@Column(name = "copertina")
	private String copertina;
	
	@ManyToOne (cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_categoria",referencedColumnName = "id")
	private Categoria categoria;
	
	@ManyToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "id_autore",referencedColumnName = "id")
	private Autore autore;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitolo()
	{
		return titolo;
	}

	public void setTitolo(String titolo)
	{
		this.titolo = titolo;
	}

	public String getTrama()
	{
		return trama;
	}

	public void setTrama(String trama)
	{
		this.trama = trama;
	}

	public String getCopertina()
	{
		return copertina;
	}

	public void setCopertina(String copertina)
	{
		this.copertina = copertina;
	}

	public Categoria getCategoria()
	{
		return categoria;
	}

	public void setCategoria(Categoria categoria)
	{
		this.categoria = categoria;
	}

	public Autore getAutore()
	{
		return autore;
	}

	public void setAutore(Autore autore)
	{
		this.autore = autore;
	}
	
}
