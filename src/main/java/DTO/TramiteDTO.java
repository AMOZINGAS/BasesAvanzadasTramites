package DTO;

import java.util.Calendar;

/**
 * 
 * @author Amos Heli Olguin Quiroz
 */
public class TramiteDTO {
    
    Long idTramite;
    private String tipo;
    private int estado;
    private int costo;
    private Calendar fechaTramite;

    /**
     * Constructor por defecto
     */
    public TramiteDTO() {
    }

    /**
     * Constructor que inicializa los atributos dados como parametros
     * @param idTramite
     * @param tipo
     * @param estado
     * @param costo
     * @param fechaTramite 
     */
    public TramiteDTO(Long idTramite, String tipo, int estado, int costo, Calendar fechaTramite) {
        this.idTramite = idTramite;
        this.tipo = tipo;
        this.estado = estado;
        this.costo = costo;
        this.fechaTramite = fechaTramite;
    }

    /**
     * Metodo que regresa el tipo de tramite
     * @return 
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * metodo que regresa el id del tramite
     * @return 
     */
    public Long getIdTramite() {
        return idTramite;
    }

    /**
     * metodo que setea el id del tramite
     * @param idTramite 
     */
    public void setIdTramite(Long idTramite) {
        this.idTramite = idTramite;
    }

    /**
     * metdo que setea el tipo de tramite
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * metdo que regresa el estado del tramite
     * @return 
     */
    public int getEstado() {
        return estado;
    }

    /**
     * metodoo que setea el estado del tramite
     * @param estado 
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * metodo que regresa el costo del tramite
     * @return 
     */
    public int getCosto() {
        return costo;
    }

    /**
     * metdoo que setea el costo del tramite
     * @param costo 
     */
    public void setCosto(int costo) {
        this.costo = costo;
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