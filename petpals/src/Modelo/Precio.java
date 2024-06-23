package Modelo;

public class Precio {
	private int id;
	private String tarifa_corte_de_pelo;
	private String tarifa_paseos;
	private String tarifa_baños;
	private String tarifa_alojamiento;
	@Override
	public String toString() {
		return "precioss [id=" + id + ", tarifa_corte_de_pelo=" + tarifa_corte_de_pelo + ", tarifa_paseos=" + tarifa_paseos
				+ ", tarifa_baños=" + tarifa_baños + ", tarifa_alojamiento=" + tarifa_alojamiento + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTarifa_corte_de_pelo() {
		return tarifa_corte_de_pelo;
	}
	public void setTarifa_corte_de_pelo(String tarifa_corte_de_pelo) {
		this.tarifa_corte_de_pelo = tarifa_corte_de_pelo;
	}
	public String getTarifa_paseos() {
		return tarifa_paseos;
	}
	public void setTarifa_paseos(String tarifa_paseos) {
		this.tarifa_paseos = tarifa_paseos;
	}
	public String getTarifa_baños() {
		return tarifa_baños;
	}
	public void setTarifa_baños(String tarifa_baños) {
		this.tarifa_baños = tarifa_baños;
	}
	public String getTarifa_alojamiento() {
		return tarifa_alojamiento;
	}
	public void setTarifa_alojamiento(String tarifa_alojamiento) {
		this.tarifa_alojamiento = tarifa_alojamiento;
	}
	public Precio(int id, String tarifa_corte_de_pelo, String tarifa_paseos, String tarifa_baños, String tarifa_alojamiento) {
		super();
		this.id = id;
		this.tarifa_corte_de_pelo = tarifa_corte_de_pelo;
		this.tarifa_paseos = tarifa_paseos;
		this.tarifa_baños = tarifa_baños;
		this.tarifa_alojamiento = tarifa_alojamiento;
	}
	public Precio() {
		// TODO Auto-generated constructor stub
	}


}
