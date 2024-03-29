/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package controlador;

/**
 *
 * @author elimo
 */

    
public enum TipoPlaca {
    
    NUEVO(1500),
    RENOVADO(1000);

    private int precio;

    private TipoPlaca(int precio) {
        this.precio = precio;
    }

    public int getPrecio() {
        return precio;
    }
}
    
    
