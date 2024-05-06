package ar.edu.unju.fi.ejercio6.interfaces.funcionales;

@FunctionalInterface
public interface Converter<T,T1> {	//T tipo de dato, T1 otro tipo mas, de otra clase
	//unico metodo:
	T1 convert(T t);	//T1 tipo de retorno, nombre del metodo y el parametro que recibe T.
	
	//en la interface funcional esta permitido añadir metodos estaticos.
	
	static <T> boolean isNotNull(T t) {	
		return t != null;
	}
	
	default void mostrarObjeto(T1 t1) {
		System.out.println("Objeto - " + t1.toString());	//t1 es el objeto que resulto convertido
	}
	
}
