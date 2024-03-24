package entidades;

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
    
    @Column(name = "rfc", nullable = false, length = 13, unique = true)
    private String rfc;
    
    @Column(name = "curp", nullable = false, length = 18, unique = true)
    private String curp;

    @Column(name = "discapacidad", nullable = false)
    private boolean discapacidad;
    
    @Column(name = "telefono", nullable = false, length = 15, unique = true)
    private String telefono;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombres;

    @Column(name = "apellidoPaterno", nullable = false, length = 25)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", nullable = false, length = 25)
    private String apellidoMaterno;
    
    @OneToMany(mappedBy = "personaLicencia", cascade = {CascadeType.REMOVE, CascadeType.PERSIST, CascadeType.MERGE})
    private List<LicenciaEntidad> licencia;
    
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<TramiteEntidad> tramites;
    
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<VehiculoEntidad> vehiculo;

    /**
     * constructor por defecto
     */
    public PersonaEntidad() {
    }

    /**
     * Metodo que inicializa a persona para utilizar sus datos
     * @param fechaNacimiento
     * @param rfc
     * @param curp
     * @param telefono
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno 
     */
    public PersonaEntidad(Calendar fechaNacimiento, String rfc, String curp, boolean discapacidad, String telefono, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.fechaNacimiento = fechaNacimiento;
        this.rfc = rfc;
        this.curp = curp;
        this.discapacidad = discapacidad;
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
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

    public List<LicenciaEntidad> getLicencia() {
        return licencia;
    }

    public void setLicencia(List<LicenciaEntidad> licencia) {
        this.licencia = licencia;
    }

    public List<TramiteEntidad> getTramites() {
        return tramites;
    }

    public void setTramites(List<TramiteEntidad> tramites) {
        this.tramites = tramites;
    }
    
    public List<VehiculoEntidad> getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(List<VehiculoEntidad> vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Long getIdPersona() {
        return idPersona;
    }
    
    public String getRfc() {
        return rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
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

    /**
     * metodo que regresa el hash de esta entidad
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    /**
     * metodo que compra objetos e identifica si son el mismo
     * @param obj
     * @return true en caso de ser diferentes false en caso contrario
     */
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
        return Objects.equals(this.vehiculo, other.vehiculo);
    }
    
    /**
     * metodo que regresa una lista de los valores de la entidad
     * @return lista de string
     */
    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", rfc=").append(rfc);
        sb.append(", telefono=").append(telefono);
        sb.append(", nombres=").append(nombres);
        sb.append(", apellidoPaterno=").append(apellidoPaterno);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append('}');
        return sb.toString();
    }

}