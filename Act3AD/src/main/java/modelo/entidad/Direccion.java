package modelo.entidad;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Direccion {
	@Column(name="tipo_via")
	private String tipoVia;
	@Column(name="nombre_via")
	private String nombreVia;
	@Column(name="ciudad")
	private String ciudad;
	
	public String getTipoVia() {
		return tipoVia;
	}
	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}
	public String getNombreVia() {
		return nombreVia;
	}
	public void setNombreVia(String nombreVia) {
		this.nombreVia = nombreVia;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	@Override
	public String toString() {
		return "Direccion [tipoVia=" + tipoVia + ", nombreVia=" + nombreVia + ", ciudad=" + ciudad + "]";
	}	
}
