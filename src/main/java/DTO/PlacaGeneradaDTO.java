package DTO;

import java.util.Calendar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author PC
 */
public class PlacaGeneradaDTO {
    
    private Long id;
    private int costo;
    private String numeroPlaca;
    private Calendar fechaTramite;

    public PlacaGeneradaDTO() {
    }

    public PlacaGeneradaDTO(Long id, int costo, String numeroPlaca, Calendar fechaTramite) {
        this.id = id;
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

    public Long getId() {
        return id;
    }
    
}
