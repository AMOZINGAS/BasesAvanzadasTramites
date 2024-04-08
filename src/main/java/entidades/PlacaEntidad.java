package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Clase de las placas entidad
 * @author Amós Helí Olguín Quiróz
 */
@Entity
public class PlacaEntidad extends TramiteEntidad implements Serializable {
    
    @Column (name = "numeroPlaca", nullable = false, length = 25)
    private String numeroPlaca;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idVehiculo")
    private VehiculoEntidad vehiculo;

    /**
     * Constructor por defecto
     */
    public PlacaEntidad() {
    }

    /**
     * Constructor que inicializa los parametro
     * @param numeroPlaca tipo string
     * @param vehiculo tipo vehiculo entidad
     * @param fechaTramite tipo calendar
     * @param costo tipo int
     * @param persona tipo persona entdiad
     * @param estado tipo int
     * @param tipo tipo string
     */
    public PlacaEntidad(String numeroPlaca, VehiculoEntidad vehiculo, Calendar fechaTramite, int costo, PersonaEntidad persona, int estado, String tipo) {
        super(costo, fechaTramite, persona, estado, tipo);
        this.numeroPlaca = numeroPlaca;
        this.vehiculo = vehiculo;
    }

    /**
     * Metodo que regresa el vehiculo de la placa
     * @return  vehiculo
     */
    public VehiculoEntidad getVehiculo() {
        return vehiculo;
    }

    /**
     * metodo que setea el vehiculo de la placa
     * @param vehiculo tipo vehiculo entidad
     */
    public void setVehiculo(VehiculoEntidad vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * metodo que regresa el numero de placa
     * @return numeroplaca
     */
    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    /**
     * metodo que setea el numero de la placa
     * @param numeroPlaca tipo string
     */
    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }
    
    /**
     * metodo que regresa una lista de cadenas con los datso de cada atributo
     * @return string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlacaEntidad{");
        sb.append(", numeroPlaca=").append(numeroPlaca);
        sb.append(", vehiculo=").append(vehiculo);
        sb.append('}');
        return sb.toString();
    }

    

}
