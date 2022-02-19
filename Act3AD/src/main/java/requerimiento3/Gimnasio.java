package requerimiento3;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Gimnasio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_gimnasio")
	private int idGimnasio;
	private String nombre;
	@OneToMany(mappedBy="gym", cascade=CascadeType.ALL) 
	private List<Clase> clases;
	
	@OneToMany(mappedBy="gimnasio", cascade=CascadeType.ALL) 
	private List<Socio> listaSocios;
	
	@OneToOne/*(cascade= CascadeType.ALL)*/ 
	
	@JoinColumn(name = "fk_id_gimnasio", referencedColumnName = "id_direccion")
	private Direccion direccion;
	
	public int getIdGimnasio() {
		return idGimnasio;
	}
	public void setIdGimnasio(int idGimnasio) {
		this.idGimnasio = idGimnasio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "Gimnasio [idGimnasio=" + idGimnasio + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
	
	

}
