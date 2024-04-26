package ar.edu.unju.fi.ejercio4.model;

import java.time.LocalDate;
import java.time.Period;

import ar.edu.unju.fi.ejercio4.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fecha_Nacimiento;
	private String nacionalidad;
	private float estatura;
	private float peso;
	private Posicion posicion;
	
	public Jugador() {
		// TODO Auto-generated constructor stub
	}

	public Jugador(String nombre, String apellido, LocalDate fecha_Nacimiento, String nacionalidad, float estatura,
			float peso, Posicion posicion) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.fecha_Nacimiento = fecha_Nacimiento;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFecha_Nacimiento() {
		return fecha_Nacimiento;
	}

	public void setFecha_Nacimiento(LocalDate fecha_Nacimiento) {
		this.fecha_Nacimiento = fecha_Nacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public float getEstatura() {
		return estatura;
	}

	public void setEstatura(float estatura) {
		this.estatura = estatura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}
	
	 public static int calcularEdad(LocalDate fechaNacimiento) {
		 LocalDate fechaActual = LocalDate.now();
		 Period periodo = Period.between(fechaNacimiento, fechaActual);
		 int edad = periodo.getYears();
		 return edad; 
	 }

	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", apellido=" + apellido + ", fecha_Nacimiento=" + fecha_Nacimiento
				+ ", nacionalidad=" + nacionalidad + ", estatura=" + estatura + ", peso=" + peso + ", posicion="
				+ posicion + "]";
	}
	
	
	
}
