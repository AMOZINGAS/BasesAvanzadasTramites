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

/**
 * Clase de las personas entidad
 * @author Amós Helí Olguín Quiróz
 */
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
    
    @OneToMany(mappedBy = "persona", cascade = {CascadeType.PERSIST})
    private List<VehiculoEntidad> vehiculo;

    /**
     * constructor por defecto
     */
    public PersonaEntidad() {
    }

    /**
     * Constructor que inicializa a persona para utilizar sus datos
     * @param fechaNacimiento tipo calendar
     * @param rfc tipo string
     * @param curp tipo string
     * @param discapacidad tipo boolean
     * @param telefono tipo string
     * @param nombres tipo string
     * @param apellidoPaterno tipo string
     * @param apellidoMaterno tipo string
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

    /**
     * metodo que regresa el apellido paterno
     * @return apellidoPaterno
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * Metodo que regresa la discapacidad de la persona
     * @return  discapacidad
     */
    public boolean isDiscapacidad() {
        return discapacidad;
    }

    /**
     * Metodo que setea la discapacidad de la persona
     * @param discapacidad tipo boolean
     */
    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    /**
     * Metodo que stetea el apellido paterno de la persona 
     * @param apellidoPaterno tipo string
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * Metodo que regresa el apellido materno de la persona
     * @return apellido materno
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * Metodo que setea el apellido materno de la persona
     * @param apellidoMaterno tipo string
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * Metodo que regresa las licencia de la persona 
     * @return licencia entidad
     */
    public List<LicenciaEntidad> getLicencia() {
        return licencia;
    }

    /**
     * Metodo que setea las licencia de la persona
     * @param licencia tipo licencia entidad
     */
    public void setLicencia(List<LicenciaEntidad> licencia) {
        this.licencia = licencia;
    }

    /**
     * Metodo que regresa los tramites de la persona
     * @return tramite
     */
    public List<TramiteEntidad> getTramites() {
        return tramites;
    }

    /**
     * Metodo que setea los tramites de las personas
     * @param tramites tipo tramite entidad 
     */
    public void setTramites(List<TramiteEntidad> tramites) {
        this.tramites = tramites;
    }
    
    /**
     * Metodo que regresa los vehiculos de la persona
     * @return vehiculo
     */
    public List<VehiculoEntidad> getVehiculo() {
        return vehiculo;
    }

    /**
     * Metodo que setea los vehiculos de la persona
     * @param vehiculo tipo vehiculo entidad
     */
    public void setVehiculo(List<VehiculoEntidad> vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     *Metodo que regresa el id de la persona
     * @return idpersona
     */
    public Long getIdPersona() {
        return idPersona;
    }
    
    /**
     * Metodo que regresa el rfc de la persona
     * @return rfc
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * metodo que regresa el curp de la persona
     * @return curp
     */
    public String getCurp() {
        return curp;
    }

    /**
     * metodo que setea el curp de la persona
     * @param curp tipo string
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * metodo que setea el rfc de la persona
     * @param rfc tipo string
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * metodo que regresa el telefono de la persona
     * @return telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * metodo que setea el telefono de la persoona
     * @param telefono tipo string
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * metodo que regresa la fecha de nacimiento de la persona
     * @return fechanacimiento
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * metodo que setea la fecha de nacimiento de la persona
     * @param fechaNacimiento tipo calendar
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * metodo que regresa los nombres de la persona
     * @return nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * metodo que setea los nombres de la persona
     * @param nombres tipo string
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
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
     * @param obj tipo object
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