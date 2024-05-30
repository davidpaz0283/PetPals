package Modelo;

public class Suministro {
	private int id;
	private String suministro_peluqueria;
	private String suministro_higiene;
	private String suministro_paseos;
	private String suministro_alojamiento;
	
	public String getSuministro_peluqueria() {
		return suministro_peluqueria;
	}
	public void setSuministro_peluqueria(String suministro_peluqueria) {
		this.suministro_peluqueria = suministro_peluqueria;
	}
	public String getSuministro_higiene() {
		return suministro_higiene;
	}
	public void setSuministro_higiene(String suministro_higiene) {
		this.suministro_higiene = suministro_higiene;
	}
	public String getSuministro_paseos() {
		return suministro_paseos;
	}
	public void setSuministro_paseos(String suministro_paseos) {
		this.suministro_paseos = suministro_paseos;
	}
	public String getSuministro_alojamiento() {
		return suministro_alojamiento;
	}
	public void setSuministro_alojamiento(String suministro_alojamiento) {
		this.suministro_alojamiento = suministro_alojamiento;
	}
	
	public Suministro(int id, String suministro_peluqueria, String suministro_higiene, String suministro_paseos, String suministro_alojamiento) {
		super();
		this.id=id;
		this.suministro_peluqueria = suministro_peluqueria;
		this.suministro_higiene = suministro_higiene;
		this.suministro_paseos = suministro_paseos;
		this.suministro_alojamiento = suministro_alojamiento;
	}
	@Override
	public String toString() {
		return "Suministro [suministro_peluqueria= " + suministro_peluqueria + ", suministro_higiene=" + suministro_higiene + ", suministro_paseos=" + suministro_paseos + ", suministro_alojamiento="
				+ suministro_alojamiento +"]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	}