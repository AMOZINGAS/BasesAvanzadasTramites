package controlador;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public enum TipoLicencia {
    
    UN_ANIO(600),
    DOS_ANIOS(900),
    TRES_ANIOS(1100);

    private int descuento = 400;
    private int precio;

    /**
     * Metodo que setea el precio
     * @param precio 
     */
    private TipoLicencia(int precio) {
        this.precio = precio;
    }

    /**
     * Metodo que regresa el precio de la licencia
     * @param dispacitado
     * @return 
     */
    public int getPrecio(boolean dispacitado) {
        if(dispacitado){
            return precio-descuento;
        }else{
            return precio;
        }
    }
}