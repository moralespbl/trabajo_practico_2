package ar.edu.unju.fi.ejercio4.main;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import ar.edu.unju.fi.ejercio4.constantes.Posicion;
import ar.edu.unju.fi.ejercio4.model.Jugador;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static List<Jugador> jugadores;
	public static void main(String[] args) {
		// Ejercicio 4
		jugadores = new ArrayList<>();
		int opcion=0;
		do {
			System.out.println("==================================\r\n"
					+ "1 – Alta de jugador\r\n"
					+ "2 – Mostrar todos los jugadores.\r\n"
					+ "3 – Modificar la posición de un jugador (ingresar el nombre y el apellido del jugador)\r\n"
					+ "4 – Eliminar un jugador (ingresar el nombre y apellido).\r\n"
					+ "5 – Salir.\r\n"
					+ "Ingrese opcion:");
			opcion=validarEntero();
			switch(opcion) {
			case 1: crearJugador();break;
			case 2: ;break;
			case 3: ;break;
			case 4: ;break;
			case 5: System.out.println("Fin del Programa");break;
			default: System.out.println("Opcion incorrecta"); break;
		}
		}while (opcion != 5);

	}

	/**
	 * Controla que el valor ingresado por consola sea un entero, de lo contrario vuelve a solicitar el ingreso
	 * @return valor entero
	 */
	public static int validarEntero() {
		int n=0;
		boolean bandera;
		do {
			bandera = true;
			try {
				n= sc.nextInt();
			}
			catch(InputMismatchException e ) {
				System.out.println("Error, ingrese un valor entero:");
				bandera = false;
			}
		    sc.nextLine();
		}while(bandera == false);	
		return n;
	}
	
	/**
	 * Controla que el valor ingresado por consola sea una cadena de texto, de lo contrario vuelve a solicitar el ingreso
	 * @return cadenta de texto
	 */
	public static String validarString() {
		boolean bandera;
		String cadena=null;
		do {
			bandera = true;
			try {
			    cadena = sc.nextLine();
			} catch(InputMismatchException e ) {
				System.out.println("Error, ingrese solo cadena de caracteres:");
				bandera = false;
			}
			sc.nextLine();
		}while(bandera == false );	
		return cadena;
	}
	
	public static float validarFload() {
		 boolean bandera;
	        float numero = 0.0f;
	        do {
	            bandera = true;
	            try {
	                numero = sc.nextFloat();
	            } catch (InputMismatchException e) {
	                System.out.println("Error, ingrese solo un número decimal:");
	                bandera = false;	                
	            }
	            sc.nextLine(); // Limpiar el buffer de entrada
	        } while (bandera == false);
	        return numero;
	    }
	
	/**
	 * Muestra los elementos de un arreglo de tipo enumerado junto con su posición.
	 * @param <T>  Tipo de enumerado.
	 * @param enumerado Arreglo de tipo enumerado que se desea mostrar. 
	 */
	public static <T extends Enum<T>> void mostrarEnumerado(T[] enumerado) {
	    for (int i = 0; i < enumerado.length; i++) {
	        System.out.println((i + 1) + " - " + enumerado[i]);
	    }
	}
	
	/**
	 * Solicita al usuario que elija una posicion de una lista de opciones y valida la entrada.
	 * @return entero, indice del objeto en el array enumerado
	 */
	public static int elegirPosicion() {
		int opcion=0;
		System.out.println("---- Posiciones ------");
		mostrarEnumerado(Posicion.values());
		do {
			System.out.println("Elija una opción:");
			opcion=validarEntero();
		} while (opcion < 1 || opcion > Posicion.values().length);		
		return opcion;
	}
	
	public static void crearJugador() {
		boolean bandera;
		int num;
		Jugador jugador = new Jugador();
		System.out.println("Nombre: ");
		jugador.setNombre(validarString());
		System.out.println("Apellido: ");
		jugador.setApellido(validarString());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		do {
			bandera = true;
			System.out.print("Fecha de Nacimiento (dd-MM-yyyy): ");
		    String fechaNaciStr = validarString();
		    try {
		    	jugador.setFecha_Nacimiento(LocalDate.parse(fechaNaciStr, formatter));
		    } catch(DateTimeParseException e) {
		    	System.out.println("La fecha no se puede convertir");
		    	bandera = false;
		    }
		} while (bandera == false);
		
		System.out.println("Nacionalidad: ");
		jugador.setNacionalidad(validarString());
		System.out.println("Estatura: ");
		jugador.setEstatura(validarFload());
		System.out.println("Peso: ");
		jugador.setPeso(validarFload());
		num= elegirPosicion();
		jugador.setPosicion(Posicion.values()[num-1]);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
