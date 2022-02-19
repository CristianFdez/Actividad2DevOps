package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="libros")
public class Libro {
	
// Atributos de la clase
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_libro")
	private int idLibro;
	private String titulo;
	private double precio;
	
	@ManyToOne
	@JoinColumn(name="fk_id_editorial", referencedColumnName = "id_editorial")
	private Editorial editorial;
	
	@ManyToOne
	@JoinColumn(name="fk_id_autor", referencedColumnName = "id_autor")
	private Autor autor;
	
	@ManyToMany(mappedBy="librosLibreria", cascade=CascadeType.PERSIST)
	private List<Libreria> librerias;
	
// Constructores
	
	public Libro() {
		super();
	}
	
	public Libro(int idLibro, String titulo, double precio, Editorial editorial, Autor autor, List<Libreria> librerias) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.precio = precio;
		this.editorial = editorial;
		this.autor = autor;
		this.librerias = librerias;
	}
	
// Getter y setter
	
	public int getIdLibro() {
		return idLibro;
	}
	
	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	public List<Libreria> getLibrerias() {
		return librerias;
	}
	public void setLibrerias(List<Libreria> librerias) {
		this.librerias = librerias;
	}
	
// Metodos
	
	@Override
	public String toString() {
		return "Libro [idLibro=" + idLibro + ", titulo=" + titulo + ", precio=" + precio + ", editorial=" + editorial
				+ ", autor=" + autor + "]";
	}
		
	
}
