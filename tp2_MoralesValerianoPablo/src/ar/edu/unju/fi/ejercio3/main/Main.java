package ar.edu.unju.fi.ejercio3.main;
import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.ejercio3.constantes.Provincia;
public class Main {
	public static List<Provincia> provincias = new ArrayList<>(List.of(Provincia.values()));
	public static void main(String[] args) {
		System.out.println("---Lista de Provincias ----");
		for (Provincia provincia: provincias) {
			System.out.println("\nProvincia: "+provincia);
			System.out.println("Poblacion: "+provincia.getPoblacion()+" hab.");
			System.out.println("Superficie: "+provincia.getSuperficie()+" km2");
			System.out.println("Densidad: "+provincia.calcularDensidad(provincia.getPoblacion(), provincia.getSuperficie())+" hab. por km2");			
		}
	}
}
