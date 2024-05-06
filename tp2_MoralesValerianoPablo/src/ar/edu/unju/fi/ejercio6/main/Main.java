package ar.edu.unju.fi.ejercio6.main;

import ar.edu.unju.fi.ejercio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FelinoSalvaje gato = new FelinoSalvaje("Tanner", (byte)20, 186f);
		
		if( Converter.isNotNull(gato) == true ) {
			
			//definición de expresión lambda que define el convertidor de FelinoDomestico a
			//FelinoSalvaje. Especifico mis genericos, de entrada y salida, el objeto 'converter'
			// y la expresion lamda a la que va a obedecer, es la instaciacion de un nuevo objeto
			// basandose en los atributos del parametro de entrada.
			
			Converter<FelinoSalvaje,FelinoDomestico> converter = x -> new FelinoDomestico(x.getNombre(),
			x.getEdad(), x.getPeso());
			
			//se realiza la conversión
			FelinoDomestico felinoDomestico = converter.convert(gato);
			
			//mostramos los datos del objeto felino salvaje felino1
			converter.mostrarObjeto(felinoDomestico);
		}
		else {
			System.out.println("El objeto a convertir es nulo");
		}
	}

}
