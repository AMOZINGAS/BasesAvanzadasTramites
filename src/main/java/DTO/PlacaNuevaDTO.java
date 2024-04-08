/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Calendar;

/**
 *
 * @author Amos Heli Olguin Quiroz
 */
public class PlacaNuevaDTO {
    
    private int costo;
    private String numeroPlaca;
    private Calendar fechaTramite;

    /**
     * Constructor por defecto
     */
    public PlacaNuevaDTO() {
    }

    /**
     * Constructor que inicializa los atributos dados como parametro
     * @param costo
     * @param numeroPlaca
     * @param fechaTramite 
     */
    public PlacaNuevaDTO(int costo, String numeroPlaca, Calendar fechaTramite) {
        this.costo = costo;
        this.numeroPlaca = numeroPlaca;
        this.fechaTramite = fechaTramite;
    }

    /**
     * Metodo que regresa el costo de la placa
     * @return 
     */
    public int getCosto() {
        return costo;
    }

    /**
     * metodo que setea el costo de la placa
     * @param costo 
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }

    /**
     * metodo que regresa el numero de la placa
     * @return 
     */
    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    /**
     * metodo que setea el numero de la placa
     * @param numeroPlaca 
     */
    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    /**
     * metodo que regresa la fecha del tramite
     * @return 
     */
    public Calendar getFechaTramite() {
        return fechaTramite;
    }

    /**
     * metodo que setea la fecha del tramite
     * @param fechaTramite 
     */
    public void setFechaTramite(Calendar fechaTramite) {
        this.fechaTramite = fechaTramite;
    }    
}