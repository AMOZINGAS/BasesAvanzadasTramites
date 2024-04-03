package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 
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
     * @param numeroPlaca
     * @param vehiculo
     * @param fechaTramite
     * @param costo
     * @param persona
     * @param estado
     * @param tipo 
     */
    public PlacaEntidad(String numeroPlaca, VehiculoEntidad vehiculo, Calendar fechaTramite, int costo, PersonaEntidad persona, int estado, String tipo) {
        super(costo, fechaTramite, persona, estado, tipo);
        this.numeroPlaca = numeroPlaca;
        this.vehiculo = vehiculo;
    }

    public VehiculoEntidad getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoEntidad vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getNumeroPlaca() {
        return numeroPlaca;
    }

    public void setNumeroPlaca(String numeroPlaca) {
        this.numeroPlaca = numeroPlaca;
    }
    
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
