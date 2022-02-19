package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="editoriales")
public class Editorial {
	
	// Atributos de clase
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_editorial")
	private int idEditorial;
	@Column(name="nombre_editorial")
	private String nombreEditorial;
	@Embedded
	private Direccion direccion;
	@OneToMany(mappedBy="editorial", cascade = CascadeType.ALL)
	private List<Libro> librosEditorial;
	
	// Constructores
	public Editorial() {
		super();
	}
	public Editorial(int idEditorial, String nombreEditorial, Direccion direccion) {
		super();
		this.idEditorial = idEditorial;
		this.nombreEditorial = nombreEditorial;
		this.direccion = direccion;
	}
	
	// Getters y setters
	public int getIdEditorial() {
		return idEditorial;
	}
	public void setIdEditorial(int idEditorial) {
		this.idEditorial = idEditorial;
	}
	public String getNombreEditorial() {
		return nombreEditorial;
	}
	public void setNombreEditorial(String nombreEditorial) {
		this.nombreEditorial = nombreEditorial;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public List<Libro> getLibrosEditorial() {
		return librosEditorial;
	}
	public void setLibrosEditorial(List<Libro> librosEditorial) {
		this.librosEditorial = librosEditorial;
	}
	
	
	// Metodos de clase
	@Override
	public String toString() {
		return "Editorial [idEditorial=" + idEditorial + ", nombreEditorial=" + nombreEditorial + ", direccion="
				+ direccion+"]";
	}
	
}
