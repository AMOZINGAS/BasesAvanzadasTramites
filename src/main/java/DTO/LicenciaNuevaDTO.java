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
public class LicenciaNuevaDTO {
    
    private int vigencia;
    private int folio;
    private int costo;
    private Calendar fechaTramite;
    private int estado;

    public LicenciaNuevaDTO() {
    }

    public LicenciaNuevaDTO(int vigencia, int folio, int costo, Calendar fechaTramite, int estado) {
        this.vigencia = vigencia;
        this.folio = folio;
        this.costo = costo;
        this.fechaTramite = fechaTramite;
        this.estado = estado;
    }

    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    public int getFolio() {
        return folio;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Calendar getFechaTramite() {
        return fechaTramite;
    }

    public void setFechaTramite(Calendar fechaTramite) {
        this.fechaTramite = fechaTramite;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
