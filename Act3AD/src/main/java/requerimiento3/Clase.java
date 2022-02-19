package requerimiento3;

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
@Entity
public class Clase {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_clase")
	private int idClase;
	private String nombreClase;
	@ManyToOne
	@JoinColumn(name="fk_id_gimnasio", referencedColumnName = "id_gimnasio")
	private Gimnasio gym;
	private String duracion;
	
	@ManyToMany(mappedBy="listaClases", cascade=CascadeType.PERSIST) 
	private List<Socio> listaSocio;
	
	
	public int getIdClase() {
		return idClase;
	}
	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}
	public String getNombreClase() {
		return nombreClase;
	}
	public void setNombreClase(String nombreClase) {
		this.nombreClase = nombreClase;
	}
	public String getDuracion() {
		return duracion;
	}
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	public List<Socio> getListaSocio() {
		return listaSocio;
	}
	public void setListaSocio(List<Socio> listaSocio) {
		this.listaSocio = listaSocio;
	}
	
	
	@Override
	public String toString() {
		return "Clase [idClase=" + idClase + ", nombreClase=" + nombreClase + ", duracion=" + duracion + ", listaSocio="
				+ listaSocio + "]";
	}
	
	
	

}
