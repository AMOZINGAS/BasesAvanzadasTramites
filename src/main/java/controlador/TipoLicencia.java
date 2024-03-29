/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 *
 * @author PC
 */
public enum TipoLicencia {
    
    UN_ANIO(600),
    DOS_ANIOS(900),
    TRES_ANIOS(1100);

    private int descuento;
    private int precio;

    private TipoLicencia(int precio) {
        this.precio = precio;
    }

    public int getPrecio(boolean dispacitado) {
        
        if(dispacitado){
            
            return precio-descuento;
            
        }else{
            
            return precio;
            
        }
    
    }

}