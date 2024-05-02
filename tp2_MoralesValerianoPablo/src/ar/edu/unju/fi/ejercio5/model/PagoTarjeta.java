package ar.edu.unju.fi.ejercio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private double monto;
	
	
	
	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double monto) {
		// super();         que es??????
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.monto = monto;
	}

	@Override
	public void realizarPago(double monto) {
		

	}

	@Override
	public void imprimirRecibo() {
		

	}

}
