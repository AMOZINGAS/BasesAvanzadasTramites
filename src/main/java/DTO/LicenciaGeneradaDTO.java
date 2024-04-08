package DTO;

import java.util.Calendar;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public class LicenciaGeneradaDTO {
    
    private Long id;
    private int vigencia;
    private int folio;
    private int costo;
    private Calendar fechaTramite;
    private int estado;

    /**
     * Constructor por defecto
     */
    public LicenciaGeneradaDTO() {
    }

    /**
     * Constructor que inicializa los valores dados como parametro
     * @param id
     * @param vigencia
     * @param folio
     * @param costo
     * @param fechaTramite
     * @param estado 
     */
    public LicenciaGeneradaDTO(Long id, int vigencia, int folio, int costo, Calendar fechaTramite, int estado) {
        this.id = id;
        this.vigencia = vigencia;
        this.folio = folio;
        this.costo = costo;
        this.fechaTramite = fechaTramite;
        this.estado = estado;
    }

    /**
     * metodo que regresa el id de la licencia 
     * @return 
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Metodo que setea el id
     * @param id tipo long
     */
    public void setId(Long id){
        this.id = id;
    }

    /**
     * metodo que regresa la vigencia de a licencia
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
     * metodo que setea el costo de la licencia
     * @param costo 
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }

    /**
     * netodo que regresa la fecha del tramite
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
     * metodo que regresa el estado de a licencia 
     * @return 
     */
    public int getEstado() {
        return estado;
    }

    /**
     * metodo que setea el estado del tramite
     * @param estado 
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
}