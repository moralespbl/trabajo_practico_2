package ar.edu.unju.fi.ejercio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;	//este atributo se actualiza usando el metodo realizarPago(), le paso la sumatoria de todos los produc seleccionados
	
	public PagoTarjeta() {
		// TODO Auto-generated constructor stub
	}
	
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
		return montoPagado;
	}

	public void setMonto(double monto) {
		this.montoPagado = monto;
	}

	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double monto) {
		// super();         que es??????
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
		this.montoPagado = monto;
	}

	@Override
	public void realizarPago(double monto) {
		monto = monto * 0.9;
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("Número de tarjeta: "+getNumeroTarjeta()+"\r\n"
				+ "Fecha de pago: "+getFechaPago()+"\r\n"
				+ "Monto pagado: "+getMonto());
	}

}
