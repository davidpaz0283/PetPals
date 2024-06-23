package Modelo;

public class Registro {
	private int id;
	private String nombre_mascota;
	private String edad_mascota;
	private String especie;
	
	public String getNombre_mascota() {
		return nombre_mascota;
	}
	public void setNombre_mascota(String nombre_mascota) {
		this.nombre_mascota = nombre_mascota;
	}
	public String getEdad_mascota() {
		return edad_mascota;
	}
	public void setEdad_mascota(String edad_mascota) {
		this.edad_mascota = edad_mascota;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
		
	public Registro(int id, String nombre_mascota, String edad_mascota, String especie) {
		super();
		this.id=id;
		this.nombre_mascota = nombre_mascota;
		this.edad_mascota = edad_mascota;
		this.especie = especie;
	}
	public Registro() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Servicio [nombre_mascota= " + nombre_mascota + ", edad_mascota=" + edad_mascota + ", especie=" + especie + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	}