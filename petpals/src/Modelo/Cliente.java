package Modelo;

public class Cliente {
	private int id;
	private String nombreYApellido;
	private String domicilio;
	private String telefono;
	@Override
	public String toString() {
		return "Clientes [id=" + id + ", nombreYApellido=" + nombreYApellido + ", domicilio=" + domicilio
				+ ", telefono=" + telefono + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombreYApellido() {
		return nombreYApellido;
	}
	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}
	public String getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Cliente(int id, String nombreYApellido, String domicilio, String telefono) {
		super();
		this.id = id;
		this.nombreYApellido = nombreYApellido;
		this.domicilio = domicilio;
		this.telefono = telefono;
	}
	
	
}
