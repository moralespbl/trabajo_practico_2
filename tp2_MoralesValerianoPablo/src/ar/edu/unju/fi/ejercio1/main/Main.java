package ar.edu.unju.fi.ejercio1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercio1.model.Producto;
import ar.edu.unju.fi.ejercio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercio1.model.Producto.OrigenFabricacion;

public class Main {	

	public static List<Producto> productos;	//reservando espacio en la memoria 
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		// Ejercicio 1
		int opcion=0;
		productos = new ArrayList<>();  //crea una nueva instancia de ArrayList
		
		do {
			System.out.println("==================================");
			System.out.println("1 – Crear Producto");
			System.out.println("2 – Mostrar productos");
			System.out.println("3 – Modificar producto (sólo puede modificar: descripción, precio unitario, origen fabricación o categoría).");
			System.out.println("4 – Salir.");
			System.out.println("Ingrese Opcion: ");
			opcion=validarEntero();
			switch(opcion){
			case 1: crearProducto();break;
			case 2: mostrarProductos();break;
			case 3: modificaProducto();break;
			case 4: System.out.println("Fin del programa");break;
			default: System.out.println("Opcion incorrecta");
			}

		} while( opcion<1 || opcion>4 || opcion != 4);

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
	 *  Crea un nuevo objeto producto y lo agrega a la lista productos, si el producto no existe.
	 * Solicita al usuario que ingrese atributos del producto
	 * Si el producto ya existe, muestra un mensaje y no carga ningun objeto a la lista.	 * 
	 */
	public static void crearProducto() {
		Integer opcion = 0;
		Producto producto = new Producto();
		System.out.println("Ingrese codigo:");
		producto.setCodigo(validarString());
		if(buscarProducto(producto.getCodigo()) == null) {
			System.out.println("Ingrese descripcion:");
			producto.setDescripcion(validarString());
			System.out.println("Ingrese precio unitario:");
			producto.setPrecioUnitario(validarEntero());
			
			opcion = elegirOrigen();
			producto.setOrigenFabricacion(OrigenFabricacion.values()[opcion-1]);
			
			opcion = elegirCategoria();
			producto.setCategoria(Categoria.values()[opcion-1]);
			
			productos.add(producto);
		} else {
			System.out.println("El producto ya existe");
		}		
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
	 * Solicita al usuario que elija un origen de fabricación de una lista de opciones y valida la entrada.
	 * @return entero, indice del objeto en el array enumerado
	 */
	public static int elegirOrigen() {
		int opcion=0;
		System.out.println("---- Origen de fabricación ------");
		mostrarEnumerado(OrigenFabricacion.values());
		do {
			System.out.println("Elija una opción:");
			opcion=validarEntero();
		} while (opcion < 1 || opcion > OrigenFabricacion.values().length);		
		return opcion;
	}
	
	/**
	 * Solicita al usuario que elija una categoria de una lista de opciones y valida la entrada.
	 * @return entero, indice del objeto en el array enumerado
	 */
	public static int elegirCategoria() {
		int opcion=0;
		System.out.println("------ Categoría ------");
		mostrarEnumerado(Categoria.values());
		do {
			System.out.println("Elija una opción:");
			opcion=validarEntero();
		} while (opcion < 1 || opcion > Categoria.values().length);
		return opcion;
	}
	

	public static void mostrarProductos() {
		System.out.println("---Lista de Productos ----");
		productos.forEach(p->System.out.println(p));
	}
	
	/**
	 * Solicita al usuario que ingrese el código de un producto y luego permite modificar sus atributos.
	 * El usuario puede elegir qué atributo modificar: descripción, precio unitario, origen de fabricación o categoría.
	 */
	public static void modificaProducto() {
		System.out.println("Ingrese codigo:");
		int opcion;
		String codigo=(validarString());
		Producto productoEncontrado=buscarProducto(codigo);
		if (productoEncontrado != null) {
			int i=0;
			int num=productos.indexOf(productoEncontrado);			
			do {
				System.out.println("========================");
				System.out.println("Que desea modificar?:");
				System.out.println("1 - Descripción");
				System.out.println("2 - Precio unitario");
				System.out.println("3 - Origen fabricación");
				System.out.println("4 - Categoría");
				System.out.println("Ingrese una opcion: ");
				i=validarEntero();
				switch(i) {
				case 1: 
					System.out.println("Ingrese descripcion:");
					productos.get(num).setDescripcion(validarString());
					break;
				case 2:
					System.out.println("Ingrese precio unitario:");
					productos.get(num).setPrecioUnitario(validarEntero());
					break;
				case 3:
					opcion = elegirOrigen();
					productos.get(num).setOrigenFabricacion(OrigenFabricacion.values()[opcion-1]);
					break;
				case 4:
					opcion = elegirCategoria();
					productos.get(num).setCategoria(Categoria.values()[opcion-1]);
					break;
				default:
						System.out.println("Opcion incorrecta");
					break;		
				}				
				
			} while( i<0 || i > 4);
			
		} else {
			System.out.println("No existe producto a modificar");
		}
	}
	/**
	 * Busca un producto en la lista de productos por su código.
	 * @param codigo El código del producto que se desea buscar.
	 * @return El producto encontrado, o null si no se encontró ningún producto con el código especificado.
	 */
	public static Producto buscarProducto(String codigo) {
		Producto productoEncontrado = null;
		for (Producto producto: productos) {
			if(producto.getCodigo().equals(codigo)){
				productoEncontrado = producto;
			}
		}
		return productoEncontrado;
	}
	
	
}


