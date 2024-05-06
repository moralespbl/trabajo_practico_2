package ar.edu.unju.fi.ejercio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.function.Function;

import ar.edu.unju.fi.ejercio5.model.Producto;
import ar.edu.unju.fi.ejercio5.model.Producto.Categoria;
import ar.edu.unju.fi.ejercio5.model.Producto.OrigenFabricacion;
//import ar.edu.unju.fi.ejercio5.model.Producto.OrigenFabricacion;

public class Main {
	public static List<Producto> productos;	
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// Ejercicio 6
		int opcion=0;
		precargaProductos();
		do {
			System.out.println("========================================\r\n"
					+ "1 – Mostrar productos \r\n"
					+ "2 – Mostrar los productos faltantes \r\n"
					+ "3 – Incrementar los precios de los productos en un 20%\r\n"
					+ "4 – Mostrar los productos de la categoría Electrohogar y disponibles para la\r\n"
					+ "venta.\r\n"
					+ "5 – Ordenar los productos por precio de forma descendente.\r\n"
					+ "6 - Mostrar los productos con los nombres en mayúsculas.\r\n"
					+ "7 - Salir.");
			System.out.println("Ingrese opcion");
			opcion = validarEntero();
			switch(opcion){
			case 1: 
				Consumer<Producto> printConsumer = c->System.out.println(c);
				productos.forEach(printConsumer);
				break;
			case 2: 
				List<Producto> faltantes = new ArrayList<>();
				Predicate<Producto> filterEstado = p -> p.isEstado() == false ;
				faltantes = productos.stream().filter(filterEstado).collect(Collectors.toList());
				Consumer<Producto> printFaltante = c->System.out.println(c);
				faltantes.forEach(printFaltante);
				break;
			case 3: 
				Function<Producto, Double> incrementarPrecio = p -> p.getPrecioUnitario() * 1.2;
				List<Double> productosIncrementados = new ArrayList<>();
				productosIncrementados = productos.stream()
		                 .map(incrementarPrecio)
		                 .collect(Collectors.toList());
		        System.out.println("Precios unitarios incrementados:");
		        productosIncrementados.forEach(System.out::println);
				break;
			case 4: 
				List<Producto> electroYDisponibles = new ArrayList<>();
				Predicate<Producto> filterElectroYDispinibles = p -> (p.isEstado() == true) && (p.getCategoria().equals("ELECTROHOGAR"));
				electroYDisponibles = productos.stream().filter(filterElectroYDispinibles).collect(Collectors.toList());
				electroYDisponibles.forEach(System.out::println);
				break;
			case 5: 
				 productos.sort(Comparator.comparing(Producto::getPrecioUnitario).reversed());

			        System.out.println("Productos ordenados por precio de forma descendente:");
			    productos.forEach(System.out::println);
				break;
			case 6: 
				 productos.stream()
                 .map(producto -> producto.getDescripcion().toUpperCase())
                 .forEach(System.out::println);
    
				break;
			case 7: 
				System.out.println("Fin del programa");break;
			default:System.out.println("Opcion incorrecta"); break;
			}			
		} while ( opcion != 7 );
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
