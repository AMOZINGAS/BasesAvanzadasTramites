package Entidades;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class PersonaEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPersona")
    private Long idPersona;

    @Column(name = "fechaNacimiento", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaNacimiento;
    
    @Column(name = "rfc", nullable = false, length = 13)
    private String rfc;

    @Column(name = "telefono", nullable = false, length = 15)
    private String telefono;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombres;

    @Column(name = "apellidoPaterno", nullable = false, length = 25)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", nullable = false, length = 25)
    private String apellidoMaterno;
    
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.PERSIST})
    @JoinColumn(name = "idLicencia")
    private LicenciaEntidad licencia;
    
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<TramiteEntidad> tramites;
    
//    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
//    private List<TramiteEntidad> tramites;
//    
//    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
//    private List<PlacaEntidad> placas;
//    
//    @OneToMany(mappedBy = "cliente", cascade = {CascadeType.MERGE, CascadeType.REMOVE})
//    private List<LicenciaEntidad> licencias;
    
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<VehiculoTieneCliente> vehiculoCliente;
    
    


    public PersonaEntidad() {
    }

    public PersonaEntidad(Calendar fechaNacimiento, String rfc, String telefono, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.fechaNacimiento = fechaNacimiento;
        this.rfc = rfc;
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
//        this.tramites = tramites;
//        this.placas = placas;
//        this.licencias = licencias;
//        this.vehiculoCliente = vehiculoCliente;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public LicenciaEntidad getLicencia() {
        return licencia;
    }

    public void setLicencia(LicenciaEntidad licencia) {
        this.licencia = licencia;
    }

//    public List<PlacaEntidad> getPlacas() {
//        return placas;
//    }
//
//    public void setPlacas(List<PlacaEntidad> placas) {
//        this.placas = placas;
//    }
//
//    public List<LicenciaEntidad> getLicencias() {
//        return licencias;
//    }
//
//    public void setLicencias(List<LicenciaEntidad> licencias) {
//        this.licencias = licencias;
//    }

    public List<TramiteEntidad> getTramites() {
        return tramites;
    }

    public void setTramites(List<TramiteEntidad> tramites) {
        this.tramites = tramites;
    }
    
    public List<VehiculoTieneCliente> getVehiculoCliente() {
        return vehiculoCliente;
    }

    public void setVehiculoCliente(List<VehiculoTieneCliente> vehiculoCliente) {
        this.vehiculoCliente = vehiculoCliente;
    }

    public Long getIdPersona() {
        return idPersona;
    }
    
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }


    public String getApellido_paterno() {
        return apellidoPaterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellidoPaterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellidoMaterno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellidoMaterno = apellido_materno;
    }

//    public List<TramiteEntidad> getTramites() {
//        return tramites;
//    }
//
//    public void setTramites(List<TramiteEntidad> tramites) {
//        this.tramites = tramites;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonaEntidad other = (PersonaEntidad) obj;
        if (!Objects.equals(this.rfc, other.rfc)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.nombres, other.nombres)) {
            return false;
        }
        if (!Objects.equals(this.apellidoPaterno, other.apellidoPaterno)) {
            return false;
        }
        if (!Objects.equals(this.apellidoMaterno, other.apellidoMaterno)) {
            return false;
        }
        if (!Objects.equals(this.idPersona, other.idPersona)) {
            return false;
        }
        if (!Objects.equals(this.fechaNacimiento, other.fechaNacimiento)) {
            return false;
        }
        if (!Objects.equals(this.licencia, other.licencia)) {
            return false;
        }
        if (!Objects.equals(this.tramites, other.tramites)) {
            return false;
        }
        return Objects.equals(this.vehiculoCliente, other.vehiculoCliente);
    }

    

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("ClienteEntidad{");
        sb.append("idCliente=").append(idPersona);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", rfc=").append(rfc);
        sb.append(", telefono=").append(telefono);
        sb.append(", nombres=").append(nombres);
        sb.append(", apellidoPaterno=").append(apellidoPaterno);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
//        sb.append(", tramites=").append(tramites);
//        sb.append(", placas=").append(placas);
//        sb.append(", licencias=").append(licencias);
        sb.append(", vehiculoCliente=").append(vehiculoCliente);
        sb.append('}');
        return sb.toString();
    }

    

}
