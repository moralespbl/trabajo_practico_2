package ar.edu.unju.fi.ejercio2.model;

import ar.edu.unju.fi.ejercio2.constantes.Mes;

public class Efemeride {
	private String codigo;
	private Mes mes;
	private Integer dia;
	private String detalle;
	
	public Efemeride() {
		// TODO Auto-generated constructor stub
	}

	public Efemeride(String codigo, Mes mes, Integer dia, String detalle) {
		super();
		this.codigo = codigo;
		this.mes = mes;
		this.dia = dia;
		this.detalle = detalle;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public Integer getDia() {
		return dia;
	}

	public void setDia(Integer dia) {
		this.dia = dia;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	
}
