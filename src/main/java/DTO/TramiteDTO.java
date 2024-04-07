package DTO;

import java.util.Calendar;

public class TramiteDTO {
    
    Long idTramite;
    private String tipo;
    private int estado;
    private int costo;
    private Calendar fechaTramite;

    public TramiteDTO() {
    }

    public TramiteDTO(Long idTramite, String tipo, int estado, int costo, Calendar fechaTramite) {
        this.idTramite = idTramite;
        this.tipo = tipo;
        this.estado = estado;
        this.costo = costo;
        this.fechaTramite = fechaTramite;
    }

    public String getTipo() {
        return tipo;
    }

    public Long getIdTramite() {
        return idTramite;
    }

    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
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
    
}
