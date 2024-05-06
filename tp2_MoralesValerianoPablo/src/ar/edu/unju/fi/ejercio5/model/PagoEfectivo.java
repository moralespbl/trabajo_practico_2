package ar.edu.unju.fi.ejercio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
	private double montoPagado;
	private LocalDate fechaPago;
	
	public PagoEfectivo() {
		// TODO Auto-generated constructor stub
	}
	public double getMontoPagado() {
		return montoPagado;
	}

	public void setMontoPagado(double montoPagado) {
		this.montoPagado = montoPagado;
	}

	public LocalDate getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}

	public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
		super();
		this.montoPagado = montoPagado;
		this.fechaPago = fechaPago;
	}

	@Override
	public void realizarPago(double monto) {
		monto = monto*1.15;
	}

	@Override
	public void imprimirRecibo() {
		System.out.println("Fecha de pago: "+getFechaPago()+"\r\n"
				+ "Monto pagado: "+getMontoPagado());

	}

}
