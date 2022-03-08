package model;

public class Product {

	
	private Integer id;
	private Integer precio;
	private String nombreProducto;
	private String descripcion;
				
	public Product(Integer id, Integer precio, String nombreProducto, String descripcion) {
		super();
		this.id = id;
		this.precio = precio;
		this.nombreProducto = nombreProducto;
		this.descripcion = descripcion;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
//	@Override
	// this method is to friendly print
	public String toString() {
		return "User [id=" + id + ", precio=" + precio + ", nombreProducto=" + nombreProducto + ", descripcion="
				+ descripcion + "]";
	}	
	

	
	
	
	
}
