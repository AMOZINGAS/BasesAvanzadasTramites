/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package POJO;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author PC
 */
public class ReportePDF {
    
    private String nombres;
    private Calendar fechaTramite;
    private String tipo;
    private int costo;
    private Date fechaTramiteDate;

    public ReportePDF(String nombres, Calendar fechaTramite, String tipo, int costo) {
        this.nombres = nombres;
        this.fechaTramite = fechaTramite;
        this.fechaTramiteDate = fechaTramite.getTime();
        this.tipo = tipo;
        this.costo = costo;
    }

    public ReportePDF() {
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Calendar getFechaTramite() {
        return fechaTramite;
    }

    public Date getFechaTramiteDate(){
        return fechaTramite.getTime();
    }
    
    public void setFechaTramiteDate(Date fechaTramiteDate){
        this.fechaTramiteDate = fechaTramiteDate;
    }
    
    public void setFechaTramite(Calendar fechaTramite) {
        this.fechaTramite = fechaTramite;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nombres);
        hash = 37 * hash + Objects.hashCode(this.fechaTramite);
        hash = 37 * hash + Objects.hashCode(this.tipo);
        hash = 37 * hash + this.costo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReportePDF other = (ReportePDF) obj;
        if (this.costo != other.costo) {
            return false;
        }
        if (!Objects.equals(this.nombres, other.nombres)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return Objects.equals(this.fechaTramite, other.fechaTramite);
    }
    
    
}
