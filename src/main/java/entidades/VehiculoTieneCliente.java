package entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class VehiculoTieneCliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="idVehiculoCliente")
    private Long id;
      
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "idVehiculo")
    private PersonaEntidad persona;
    
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(name = "idCliente")
    private VehiculoEntidad vehiculo;

    
    

    public VehiculoTieneCliente() {
    }

//    public VehiculoTieneCliente(VehiculoEntidad vehiculo, PersonaEntidad cliente) {
//        this.vehiculo = vehiculo;
//        this.cliente = cliente;
//    }

    public VehiculoEntidad getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoEntidad vehiculo) {
        this.vehiculo = vehiculo;
    }

    public PersonaEntidad getPersona() {
        return persona;
    }

    public void setCliente(PersonaEntidad persona) {
        this.persona = persona;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (id != null ? id.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof VehiculoTieneCliente)) {
//            return false;
//        }
//        VehiculoTieneCliente other = (VehiculoTieneCliente) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VehiculoTieneCliente{");
        sb.append("id=").append(id);
        sb.append('}');
        return sb.toString();
    }

    

}
