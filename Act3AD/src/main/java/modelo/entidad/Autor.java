package modelo.entidad;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="autores")
public class Autor {
	
	// Atributos de clase
	@Id
	@Column(name="id_autor")
	private int idAutor;
	@Column(name="nombre")
	private String nombreAutor;
	@Column(name="apellidos")
	private String apellidosAutor;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_nacimiento")
	private Date fechaNac;
	
	@OneToMany(mappedBy = "autor")
	private List<Libro> librosAutor;
	
	// Constructores
	
	public Autor() {
		super();
	}
	public Autor(int idAutor, String nombreAutor, String apellidosAutor, Date fechaNac, List<Libro> librosAutor) {
		super();
		this.idAutor = idAutor;
		this.nombreAutor = nombreAutor;
		this.apellidosAutor = apellidosAutor;
		this.fechaNac = fechaNac;
		this.librosAutor = librosAutor;
	}
	
	// Getters y setters
	public int getIdAutor() {
		return idAutor;
	}
	public void setIdAutor(int idAutor) {
		this.idAutor = idAutor;
	}
	public String getNombreAutor() {
		return nombreAutor;
	}
	public void setNombreAutor(String nombreAutor) {
		this.nombreAutor = nombreAutor;
	}
	public String getApellidosAutor() {
		return apellidosAutor;
	}
	public void setApellidosAutor(String apellidosAutor) {
		this.apellidosAutor = apellidosAutor;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public List<Libro> getLibrosAutor() {
		return librosAutor;
	}
	public void setLibrosAutor(List<Libro> librosAutor) {
		this.librosAutor = librosAutor;
	}
	
	// Metodos
	@Override
	public String toString() {
		return "Autor [idAutor=" + idAutor + ", nombreAutor=" + nombreAutor + ", apellidosAutor=" + apellidosAutor 
				+ ", fechaNac=" + fechaNac + "]";
	}

}
