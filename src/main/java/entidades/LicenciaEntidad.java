package entidades;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;

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
     * meotod que inciializa la entidad con los valor necesarios para el mismo
     * @param vigencia
     * @param folio 
     */
    public LicenciaEntidad(int vigencia, int folio, PersonaEntidad personaLicencia) {
        this.vigencia = vigencia;
        this.folio = folio;
        this.personaLicencia = personaLicencia;
    }

    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    public void setFolio(int folio) {
        this.folio = folio;
    }
    
    public int getFolio() {
        return folio;
    }

    public PersonaEntidad getPersonaLicencia() {
        return personaLicencia;
    }

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