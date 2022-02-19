package requerimiento3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Direccion {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id_direccion")
		private int idDireccion;
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
		public int getIdDireccion() {
			return idDireccion;
		}
		public void setIdDireccion(int idDireccion) {
			this.idDireccion = idDireccion;
		}
		public String getCiudad() {
			return ciudad;
		}
		public void setCiudad(String ciudad) {
			this.ciudad = ciudad;
		}
		@Override
		public String toString() {
			return "Direccion [idDireccion=" + idDireccion + ", tipoVia=" + tipoVia + ", nombreVia=" + nombreVia
					+ ", ciudad=" + ciudad + "]";
		}
		
}
