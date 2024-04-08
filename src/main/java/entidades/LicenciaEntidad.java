package entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Clase de las licencias entidad
 * @author Amós Helí Olguín Quiróz
 */
@Entity
@PrimaryKeyJoinColumn(name = "idTramite")
public class LicenciaEntidad extends TramiteEntidad implements Serializable {
    
    @Column(name = "vigencia", nullable = false)
    private int vigencia;
    
    @Column(name = "folio", nullable = false)
    private int folio;
    
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "idPersona")
    private PersonaEntidad personaLicencia;

    /**
     * Constructor por defecto
     */
    public LicenciaEntidad() {
    }

    /**
     * Constructor que inicializa los valores de los parametros
     * @param vigencia
     * @param folio
     * @param personaLicencia 
     */
    public LicenciaEntidad(int vigencia, int folio, PersonaEntidad personaLicencia) {
        this.vigencia = vigencia;
        this.folio = folio;
        this.personaLicencia = personaLicencia;
    }

    /**
     * Metodo que regresa la vigencia de la licencia 
     * @return 
     */
    public int getVigencia() {
        return vigencia;
    }

    /**
     * Metodo que setea la vigencia de la licencia
     * @param vigencia 
     */
    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    /**
     * Metodo que setea el folio de la licencia
     * @param folio 
     */
    public void setFolio(int folio) {
        this.folio = folio;
    }
    
    /**
     * Metodo que regresa el folio de la licencia
     * @return 
     */
    public int getFolio() {
        return folio;
    }

    /**
     * Metodo que regresa a la persona licencia
     * @return 
     */
    public PersonaEntidad getPersonaLicencia() {
        return personaLicencia;
    }

    /**
     * Metodo que setea a la persona licencia
     * @param personaLicencia 
     */
    public void setPersonaLicencia(PersonaEntidad personaLicencia) {
        this.personaLicencia = personaLicencia;
    }
    
    /**
     * metodo que genera un string con los valores de la entidad
     * @return string 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LicenciaEntidad{");
        sb.append(", vigencia=").append(vigencia);
        sb.append('}');
        return sb.toString();
    }

}