package entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PlacaEntidad extends TramiteEntidad implements Serializable {
    
    @Column (name = "numeroPlaca", nullable = false, length = 25)
    private String numeroPlaca;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idVehiculo")
    private VehiculoEntidad vehiculo;

    public PlacaEntidad() {
    }

    public PlacaEntidad(String numeroPlaca, VehiculoEntidad vehiculo) {
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
