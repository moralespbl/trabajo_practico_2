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
			case 2: mostrarJugadores() ;break;
			case 3: modificarPosicion();break;
			case 4: eliminarJugador();break;
			case 5: System.out.println("Fin del Programa");break;
			default: System.out.println("Opcion incorrecta"); break;
		}
		}while (opcion != 5);
	}
	/**
	 * Solicita al usuario el ingreso de los atributos del objeto jugador
	 * si el no existe otro jugador con el mismo nombre y apellido es agregado al a lista
	 * jugadores
	 */
	public static void crearJugador() {
		int num;
		Jugador jugador = new Jugador();
		System.out.println("Nombre: ");
		jugador.setNombre(validarString());
		System.out.println("Apellido: ");
		jugador.setApellido(validarString());
		if ( buscarJugador(jugador.getNombre(),jugador.getApellido()) == null ){
			System.out.print("Fecha de Nacimiento (dd-MM-yyyy): ");
			jugador.setFecha_Nacimiento(validarFecha());		
			System.out.println("Nacionalidad: ");
			jugador.setNacionalidad(validarString());
			System.out.println("Estatura: ");
			jugador.setEstatura(validarFload());
			System.out.println("Peso: ");
			jugador.setPeso(validarFload());
			num= elegirPosicion();
			jugador.setPosicion(Posicion.values()[num-1]);
			jugadores.add(jugador);
			System.out.println("Jugador Creado ");
		}
		else {
			System.out.println("Ya existe el jugador");
		}		
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
	/**
	 * Controla que el valor ingresado por consola sea float, de lo contrario vuelve a solicitar el ingreso
	 * @return float
	 */
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
	            sc.nextLine(); 
	        } while (bandera == false);
	        return numero;
	    }
	
	/**
	 * Valida una fecha ingresada por el usuario en el formato "dd-MM-yyyy".
	 *  @return  La fecha válida ingresada por el usuario como un objeto LocalDate.
	 */
	public static LocalDate validarFecha() {
		 LocalDate fechaNac=null;
		 boolean bandera;
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	        do {
	        	bandera = true;
	        	
			    String fechaNacStr = validarString();
	            try {
					fechaNac = LocalDate.parse(fechaNacStr, formatter);
	            } catch (DateTimeParseException e) {
	            	System.out.println("La fecha no se puede convertir");
			    	bandera = false;	                
	            }
	            sc.nextLine(); 
	        } while (bandera == false);
	        return fechaNac;
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
			System.out.println("Elija una opción disponible:");
			opcion=validarEntero();
		} while (opcion < 1 || opcion > Posicion.values().length);		
		return opcion;
	}
	
	public static Jugador buscarJugador(String nombre, String apellido) {
		Jugador jugadorEncontrado=null;
		for(Jugador jugador: jugadores) {
			if( jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido) ) {
				jugadorEncontrado = jugador;
			}
		}
		return jugadorEncontrado;
	}
	
	public static void mostrarJugadores() {
		System.out.println("---Lista de Jugadores ----");
		jugadores.forEach(j->System.out.println(j));
	}
	
	/**
	 * Se solicita al usuario ingresar el nombre y apellido del jugador cuya posición se desea modificar.
	 */
	public static void modificarPosicion() {
		int num;
		Jugador jugador = new Jugador();
		System.out.println("Nombre: ");
		jugador.setNombre(validarString());
		System.out.println("Apellido: ");
		jugador.setApellido(validarString());
		jugador = buscarJugador(jugador.getNombre(),jugador.getApellido());
		if (jugador != null ){
			int i = jugadores.indexOf(jugador);
			num= elegirPosicion();
			jugadores.get(i).setPosicion(Posicion.values()[num-1]);
			System.out.println("Posicion modificada");
		}
		else {
			System.out.println("No existe jugador");
		}	
	}
	
	/**
	 * Elimina un jugador de la lista de jugadores.
	 * Si no se encuentra el jugador en la lista, se muestra un mensaje indicando que el jugador no existe.
	 */
	public static void eliminarJugador() {
		Jugador jugador = new Jugador();
		System.out.println("Nombre: ");
		jugador.setNombre(validarString());
		System.out.println("Apellido: ");
		jugador.setApellido(validarString());
		jugador = buscarJugador(jugador.getNombre(),jugador.getApellido());
		if (jugador != null ){
			int i = jugadores.indexOf(jugador);
			jugadores.remove(i);
			System.out.println("Jugador eliminado");
		}
		else {
			System.out.println("No existe jugador");
		}	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
