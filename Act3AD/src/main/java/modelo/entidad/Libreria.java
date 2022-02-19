package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="librerias")
public class Libreria {
	
	// Atributos de clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_libreria")
	private int idLibreria;
	@Column(name="nombre_libreria")
	private String nombreLibreria;
	@Column(name="dueno")
	private String nombreDueno;
	@Embedded
	private Direccion direccion;
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="libros_librerias",
		joinColumns= {@JoinColumn(name="fk_id_libreria", referencedColumnName = "id_libreria")},
		inverseJoinColumns = {@JoinColumn(name="fk_id_libro", referencedColumnName = "id_libro")})
	private List<Libro> librosLibreria;
	
	// Constructores
	
	public Libreria() {
		super();
	}
	public Libreria(int idLibreria, String nombreLibreria, String nombreDueno, Direccion direccion) {
		super();
		this.idLibreria = idLibreria;
		this.nombreLibreria = nombreLibreria;
		this.nombreDueno = nombreDueno;
		this.direccion = direccion;

	}
	
	// Getters y setters
	public int getIdLibreria() {
		return idLibreria;
	}
	public void setIdLibreria(int idLibreria) {
		this.idLibreria = idLibreria;
	}
	public String getNombreLibreria() {
		return nombreLibreria;
	}
	public void setNombreLibreria(String nombreLibreria) {
		this.nombreLibreria = nombreLibreria;
	}
	public String getNombreDueno() {
		return nombreDueno;
	}
	public void setNombreDueno(String nombreDueno) {
		this.nombreDueno = nombreDueno;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public List<Libro> getLibrosLibreria() {
		return librosLibreria;
	}
	public void setLibrosLibreria(List<Libro> librosLibreria) {
		this.librosLibreria = librosLibreria;
	}
	
	
	// Metodos
	@Override
	public String toString() {
		return "Libreria [idLibreria=" + idLibreria + ", nombreLibreria=" + nombreLibreria + ", nombreDueno="
				+ nombreDueno + ", direccion=" + direccion + ", librosLibreria=" + librosLibreria + "]";
	}
	
}
