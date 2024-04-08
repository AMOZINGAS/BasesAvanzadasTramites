package DTO;

import java.util.Calendar;

/**
 *
 * @author Amos Heli Olguin Quiroz
 */
public class PlacaGeneradaDTO {
    
    private Long id;
    private int costo;
    private String numeroPlaca;
    private Calendar fechaTramite;

    /**
     * Constructor por defecto
     */
    public PlacaGeneradaDTO() {
    }

    /**
     * Constructor que inicializa los atributos dados como parametro
     * @param id
     * @param costo
     * @param numeroPlaca
     * @param fechaTramite 
     */
    public PlacaGeneradaDTO(Long id, int costo, String numeroPlaca, Calendar fechaTramite) {
        this.id = id;
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

    /**
     * metodo que regresa el id de la placa
     * @return 
     */
    public Long getId() {
        return id;
    }
}