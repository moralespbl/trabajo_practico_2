package ar.edu.unju.fi.ejercio2.main;

import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercio2.constantes.Mes;
import ar.edu.unju.fi.ejercio2.model.Efemeride;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static List<Efemeride> efemerides;
	public static void main(String[] args) {
		// Ejercicio 2
		int opcion = 0 ;
		efemerides = new ArrayList<>();
		do {
			System.out.println("==================================");
			System.out.println("1 – Crear efeméride");
			System.out.println("2 – Mostrar efemérides");
			System.out.println("3 – Eliminar efeméride");
			System.out.println("4 – Modificar efeméride");
			System.out.println("5 – Salir");
			System.out.println("Ingrese opcion:");
			opcion=validarEntero();
			switch(opcion) {
				case 1: ;break;
				case 2: ;break;
				case 3: ;break;
				case 4: ;break;
				case 5: ;break;
				default: System.out.println("Opcion incorrecta"); break;
			}
		} while (opcion < 1 || opcion > 5 || opcion != 5);

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
				//System.out.println("Ingrese cadena:");
			    cadena = sc.nextLine();
			} catch(InputMismatchException e ) {
				System.out.println("Error, ingrese solo cadena de caracteres:");
				bandera = false;
			}
			sc.nextLine();
		}while(bandera == false );	
		return cadena;
	}
	
	public static void crearEfemeride() {
		Efemeride efemeride = new Efemeride();
		int numMes;
		int numDia;
		System.out.println("Ingrese codigo");
		efemeride.setCodigo(validarString());
		do {
			System.out.println("Ingrese mes, del 1 al 12");
			numMes=validarEntero();
		} while(numMes<1 || numMes>12);
		efemeride.setMes(Mes.values()[numMes-1]);		
		if (numMes == 2) {
			do {
				System.out.println("Ingrese dia, del 1 al 28");
				numDia=validarEntero();
			} while(numDia<1 || numDia>29);
		} else if (numMes == 1 || numMes == 3 || numMes == 5 || numMes == 7 || numMes ==8  || numMes == 10  || numMes == 12) {
			do {
				System.out.println("Ingrese dia, del 1 al 31");
				numDia=validarEntero();
			} while(numDia<1 || numDia>32);
		} else{
			do {
				System.out.println("Ingrese dia, del 1 al 30");
				numDia=validarEntero();
			} while(numDia<1 || numDia>30);		
		} 
		efemeride.setDia(numDia);
		System.out.println("Ingrese detalle");
		efemeride.setDetalle(validarString());
		efemerides.add(efemeride);
		System.out.println("Efemerido Añadida con exito");
	}
}
