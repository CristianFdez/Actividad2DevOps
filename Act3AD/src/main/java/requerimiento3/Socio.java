package requerimiento3;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity
public class Socio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_socio")
	private int idSocio;
	private String nombreCompleto;
	private int telefono;
	private int numeroCuenta;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	
	@JoinTable(name="socios_clases",
			   joinColumns= { @JoinColumn(name="fk_id_socio", referencedColumnName="id_socio") }, 
			   inverseJoinColumns= { @JoinColumn(name="fk_id_clase", referencedColumnName="id_clase")}) 
	private List<Clase> listaClases;
	@ManyToOne
	@JoinColumn(name="fk_id_gimnasio", referencedColumnName = "id_gimnasio")
	private Gimnasio gimnasio;
	
	
	public int getIdSocio() {
		return idSocio;
	}
	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}
	public String getNombreCompleto() {
		return nombreCompleto;
	}
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public int getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public List<Clase> getListaClases() {
		return listaClases;
	}
	public void setListaClases(List<Clase> listaClases) {
		this.listaClases = listaClases;
	}
	
	
	@Override
	public String toString() {
		return "Socio [idSocio=" + idSocio + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono
				+ ", numeroCuenta=" + numeroCuenta + ", listaClases=" + listaClases + "]";
	}
	
	
	
	
	
	
}
