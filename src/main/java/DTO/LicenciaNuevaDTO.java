package DTO;

import java.util.Calendar;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public class LicenciaNuevaDTO {
    
    private int vigencia;
    private int folio;
    private int costo;
    private Calendar fechaTramite;
    private int estado;

    /**
     * Constructor por defecto
     */
    public LicenciaNuevaDTO() {
    }

    /**
     * Constructor que inicializa los atributos dados como parametro
     * @param vigencia
     * @param folio
     * @param costo
     * @param fechaTramite
     * @param estado 
     */
    public LicenciaNuevaDTO(int vigencia, int folio, int costo, Calendar fechaTramite, int estado) {
        this.vigencia = vigencia;
        this.folio = folio;
        this.costo = costo;
        this.fechaTramite = fechaTramite;
        this.estado = estado;
    }

    /**
     * metodo que regresa la vigencia de la licencia 
     * @return 
     */
    public int getVigencia() {
        return vigencia;
    }

    /**
     * metodo que setea la vigencia de la licencia 
     * @param vigencia 
     */
    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * metodo que regresa el folio de la licencia 
     * @return 
     */
    public int getFolio() {
        return folio;
    }

    /**
     * metodo que setea el folio de la licencia
     * @param folio 
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }

    /**
     * metodo que regresa el costo de la licencia
     * @return 
     */
    public int getCosto() {
        return costo;
    }

    /**
     * metodo que setea el costro de la licencia 
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

    /**
     * metodo que regresa el estaod de la licencia
     * @return 
     */
    public int getEstado() {
        return estado;
    }

    /**
     * metodo que setea el estado de la licencia
     * @param estado 
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
}