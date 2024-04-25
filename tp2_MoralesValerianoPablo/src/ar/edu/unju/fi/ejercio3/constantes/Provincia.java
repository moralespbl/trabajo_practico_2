package ar.edu.unju.fi.ejercio3.constantes;
public enum Provincia {	
	    JUJUY(797955L, 53244L), 
	    SALTA(1440672L, 155340L), 
	    TUCUMAN(1703186L, 22592L), 
	    CATAMARCA(429556L, 101486L), 
	    LA_RIOJA(384607L, 91493L), 
	    SANTIAGO_DEL_ESTERO(1054028L, 136934L);

	    private long POBLACION;
	    private long SUPERFICIE;

	    private Provincia(long POBLACION, long SUPERFICIE) {
	        this.POBLACION = POBLACION;
	        this.SUPERFICIE = SUPERFICIE;
	    }

	    public long getPoblacion() {
	        return POBLACION;
	    }

	    public long getSuperficie() {
	        return SUPERFICIE;
	    }
	    
	    public long calcularDensidad(long POBLACION, long SUPERFICIE) {
	    	return POBLACION/SUPERFICIE;
	    }

}
