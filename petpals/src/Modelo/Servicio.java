package Modelo;

import java.time.LocalDate;

public class Servicio {
	private int id;
	private String corte_de_pelo;
	private String baño;
	private String paseo;
	private String alojamiento;
	private LocalDate fecha;
	
	public String getCorte_de_pelo() {
		return corte_de_pelo;
	}
	public void setCorte_de_pelo(String corte_de_pelo) {
		this.corte_de_pelo = corte_de_pelo;
	}
	public String getBaño() {
		return baño;
	}
	public void setBaño(String baño) {
		this.baño = baño;
	}
	public String getPaseo() {
		return paseo;
	}
	public void setPaseo(String paseo) {
		this.paseo = paseo;
	}
	public String getAlojamiento() {
		return alojamiento;
	}
	public void setAlojamiento(String alojamiento) {
		this.alojamiento = alojamiento;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Servicio(int id, String corte_de_pelo, String baño, String paseo, String alojamiento, LocalDate fecha) {
		super();
		this.id=id;
		this.corte_de_pelo = corte_de_pelo;
		this.baño = baño;
		this.paseo = paseo;
		this.alojamiento = alojamiento;
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Servicio [corte_de_pelo=" + corte_de_pelo + ", baño=" + baño + ", paseo=" + paseo + ", alojamiento="
				+ alojamiento + ", fecha=" + fecha + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}

