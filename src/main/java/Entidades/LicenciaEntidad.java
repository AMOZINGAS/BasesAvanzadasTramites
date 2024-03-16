package Entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LicenciaEntidad implements Serializable {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLicencia")
    private Long id;
    
    @Column(name = "estado", nullable = false, length = 25)
    private String estado;
    
    @Column(name = "vigencia", nullable = false)
    private int vigencia;
    
    @Column(name = "costo", nullable = false)
    private int costo;
    
    
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "idCliente")
    private PersonaEntidad cliente;
    
//    @OneToOne
//    @JoinColumn(name = "idTramite", referencedColumnName = "idTramite")
//    private TramiteEntidad tramite;

   

    public LicenciaEntidad() {
    }

    public LicenciaEntidad(String estado, PersonaEntidad cliente) {
        this.estado = estado;
        this.cliente = cliente;
//        this.tramite = tramite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public TramiteEntidad getTramite() {
//        return tramite;
//    }
//
//    public void setTramite(TramiteEntidad tramite) {
//        this.tramite = tramite;
//    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public PersonaEntidad getCliente() {
        return cliente;
    }

    public void setCliente(PersonaEntidad cliente) {
        this.cliente = cliente;
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
//        if (!(object instanceof LicenciaEntidad)) {
//            return false;
//        }
//        LicenciaEntidad other = (LicenciaEntidad) object;
//        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
//            return false;
//        }
//        return true;
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LicenciaEntidad{");
        sb.append("id=").append(id);
        sb.append(", estado=").append(estado);
        sb.append(", vigencia=").append(vigencia);
        sb.append(", costo=").append(costo);
        sb.append(", cliente=").append(cliente);
        sb.append('}');
        return sb.toString();
    }

    
    

}
