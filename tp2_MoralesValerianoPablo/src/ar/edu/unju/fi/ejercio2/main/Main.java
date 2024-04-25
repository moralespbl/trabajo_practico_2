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
				case 1: crearEfemeride();break;
				case 2: mostrarEfemerides();break;
				case 3: eliminarEfemeride();break;
				case 4: modificarEfemeride();break;
				case 5: System.out.println("Fin del Programa");break;
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
	
	/**
	 * permite crear una nueva efeméride.
	 *  solicita al usuario ingresar un código para la efeméride, el mes, el 
	 *  día y el detalle de la efeméride.
	 */
	public static void crearEfemeride() {
		Efemeride efemeride = new Efemeride();
		int numMes;
		int numDia;
		System.out.println("Ingrese codigo");
		efemeride.setCodigo(validarString());
		if(buscarEfemeride(efemeride.getCodigo()) == null) {
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
		else {
			System.out.println("Ya exite la efemeride");
		}

	}

/**
 * Busca una efemeride en la lista de efemerides por su código.
 * @param codigo El código del efemeride que se desea buscar
 * @return El efemeride encontrado, o null si no se encontró ningún efemeride con el código especificado.
 */
	public static Efemeride buscarEfemeride(String codigo) {
		Efemeride efemerideEncontrada = null;
		for (Efemeride efemeride: efemerides) {
			if(efemeride.getCodigo().equals(codigo)){
				efemerideEncontrada = efemeride;
			}
		}
		return efemerideEncontrada;
	}
	
	public static void mostrarEfemerides() {
		System.out.println("---Lista de Efemerides ----");
		efemerides.forEach(e->System.out.println(e));
	}
	
	public static void eliminarEfemeride() {
		Efemeride efemeride = new Efemeride();
		System.out.println("Ingrese codigo");
		efemeride.setCodigo(validarString());
		if(buscarEfemeride(efemeride.getCodigo()) != null) {
			int	i = efemerides.indexOf(buscarEfemeride(efemeride.getCodigo()));
			efemerides.remove(i);
			System.out.println("Efemeride eliminada");
		}
		else {
			System.out.println("No existe la efemeride ingresada");
		}
	}
	
	public static void modificarEfemeride() {
		int num;
		int numDia;
		int opcion;
		Efemeride efemeride = new Efemeride();
		System.out.println("Ingrese codigo");
		efemeride.setCodigo(validarString());
		if(buscarEfemeride(efemeride.getCodigo()) != null) {
			int	i = efemerides.indexOf(buscarEfemeride(efemeride.getCodigo()));			
			do {
				System.out.println("========================");
				System.out.println("Que desea modificar?:");
				System.out.println("1 - Mes");
				System.out.println("2 - Dia");
				System.out.println("3 - Detalle");
				System.out.println("Ingrese una opcion: ");
				opcion = validarEntero();
				switch(opcion) {
				case 1: 		
					do {
						System.out.println("Ingrese mes, del 1 al 12");
						num = validarEntero();
					} while( num < 1 || num > 12);
					efemerides.get(i).setMes(Mes.values()[ num - 1 ]);
					break;
				case 2:
					int numMes = efemerides.get(i).getMes().ordinal();
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
					efemerides.get(i).setDia(numDia);					
					break;
				case 3:
					System.out.println("Modificar detalle");
					efemerides.get(i).setDetalle(validarString());	
					break;
				default:
						System.out.println("Opcion incorrecta");
					break;		
				}		
			} while( opcion<1 || opcion > 3);
			System.out.println("Cambios efectuados");
		}
		else {
			System.out.println("No existe la efemeride ingresada");
		}
	}
	
}
