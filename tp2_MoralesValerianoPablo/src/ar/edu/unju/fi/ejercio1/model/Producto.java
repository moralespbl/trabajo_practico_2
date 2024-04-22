package ar.edu.unju.fi.ejercio1.model;

public class Producto {
	private String codigo;
	private String descripcion;
	private Integer precioUnitarioa;
	private OrigenFabricacion origenFabricacion;
	private Categoria categoria;
	
	public enum OrigenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	
	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}
}
