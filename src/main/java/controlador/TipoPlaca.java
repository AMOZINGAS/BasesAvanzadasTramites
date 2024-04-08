package controlador;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public enum TipoPlaca {
    
    NUEVO(1500),
    RENOVADO(1000);

    private int precio;

    /**
     * Metodo que setea el precio de la placa
     * @param precio 
     */
    private TipoPlaca(int precio) {
        this.precio = precio;
    }

    /**
     * metodo que regresa el presio de la placa
     * @return 
     */
    public int getPrecio() {
        return precio;
    }
}
    
    
