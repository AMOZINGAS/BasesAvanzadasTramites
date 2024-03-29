/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Calendar;

/**
 *
 * @author PC
 */
public class PlacaNuevaDTO {
    
    private int costo;
    private String numeroPlaca;
    private Calendar fechaTramite;

    public PlacaNuevaDTO() {
    }

    public PlacaNuevaDTO(int costo, String numeroPlaca, Calendar fechaTramite) {
        this.costo = costo;
        this.numeroPlaca = numeroPlaca;
        this.fechaTramite = fechaTramite;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }

    public Calendar getFechaTramite() {
        return fechaTramite;
    }

    public void setFechaTramite(Calendar fechaTramite) {
        this.fechaTramite = fechaTramite;
    }
    
}
