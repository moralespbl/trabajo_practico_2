package ar.edu.unju.fi.ejercio5.main;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercio5.interfaces.Pago;
import ar.edu.unju.fi.ejercio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercio5.model.PagoTarjeta;
import ar.edu.unju.fi.ejercio5.model.Producto;
import ar.edu.unju.fi.ejercio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercio5.model.Producto.OrigenFabricacion;

public class Main {
	public static List<Producto> productos;	//reservando espacio en la memoria 
	public static List<Producto> seleccionados;	//reservando espacio en la memoria 
	public static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args) {
		// ej. 5
		
		
		int opcion=0;
		precargaProductos();
		do {
			System.out.println("==================================");
			System.out.println("1 – Mostrar Producto");
			System.out.println("2 – Realizar Compra");
			System.out.println("3 – Salir.");
			System.out.println("Ingrese Opcion: ");
			opcion=validarEntero();
			switch(opcion){
			case 1: mostrarProductos();break;
			case 2: realizarCompra();break;
			case 3: System.out.println("Fin del Programa");;break;
			default: System.out.println("Opcion incorrecta");
			}

		} while( opcion != 3);
	}
		
	/**
	 * Realiza la compra de productos seleccionados por el usuario.
	 * Permite al usuario seleccionar productos, calcular el monto total de la compra,
	 * elegir el método de pago y realizar el pago.
	 */
	private static void realizarCompra() {
		seleccionados = new ArrayList<>();  //crea una nueva instancia de ArrayList
		int num = 0;
		int codigo = 0;
		double monto = 0;
		String letra;
		do {
			do {
				mostrarProductos();
				System.out.println("Ingrese codigo del producto: ");
				codigo = validarEntero();
			}while( codigo < 1 || codigo > 15 );
			if ( productos.get(codigo-1).isEstado() == true) {
				seleccionados.add(productos.get(codigo-1));
				System.out.println("Muchas Gracias, producto añadido");
				System.out.println("Desea seguir comprando ? Ingrese: S caso contrario cualquier letra");
				letra = validarString();
			}
			else {
				System.out.println("Lo sentimos no hay stock del producto");
				letra = "S";
			}

		} while (letra.equals("S") || letra.equals("s"));
		for( Producto s:seleccionados) {
			monto = monto + s.getPrecioUnitario();
		}		
		do{
			System.out.println("1 – Pago efectivo");
			System.out.println("2 – Pago con tarjeta");
			num = validarEntero();
		} while (num > 2 || num < 1);
		if (num == 1) {
			Pago pagoEfectivo = new PagoEfectivo(monto, LocalDate.now());
			pagoEfectivo.realizarPago(monto);
			pagoEfectivo.imprimirRecibo();
			}
		else {
			System.out.println("Ingrese numero de tarjeta");
			Pago pagoTarjeta = new PagoTarjeta(validarString(), LocalDate.now(), monto);
			pagoTarjeta.realizarPago(monto);
			pagoTarjeta.imprimirRecibo();
			
		}
		seleccionados.clear();	
	}

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

	public static void mostrarProductos() {
		System.out.println("---Lista de Productos ----");
		productos.forEach(p->System.out.println(p));
	}
	
	public static void precargaProductos() {
		if ( productos== null) {
			productos = new ArrayList<>();  //crea una nueva instancia de ArrayList
		}
		productos.add(new Producto("1", "Destornillador", 100, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, false));
		productos.add(new Producto("2", "Lavarropas", 200, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("3", "Llave", 34, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, false));
		productos.add(new Producto("4", "Secarropas", 34, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("5", "Heladera", 545, OrigenFabricacion.URUGUAY, Categoria.ELECTROHOGAR, false));
		productos.add(new Producto("6", "Televisor", 565, OrigenFabricacion.CHINA, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("7", "Computadora", 67, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, false));
		productos.add(new Producto("8", "Licuadora", 156400, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, true));
		productos.add(new Producto("9", "Celular", 45, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, false));
		productos.add(new Producto("10", "Notebook", 564, OrigenFabricacion.ARGENTINA, Categoria.INFORMATICA, true));
		productos.add(new Producto("11", "Mouse", 756, OrigenFabricacion.BRASIL, Categoria.INFORMATICA, false));
		productos.add(new Producto("12", "Memoria", 78, OrigenFabricacion.URUGUAY, Categoria.INFORMATICA, true));
		productos.add(new Producto("13", "Martillo", 178700, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, false));
		productos.add(new Producto("14", "Taladro", 343, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, true));
		productos.add(new Producto("15", "Camara", 454554, OrigenFabricacion.BRASIL, Categoria.ELECTROHOGAR, false));
	}
	

}
