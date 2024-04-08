package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Amós Helí Olguín Quiróz
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo")
public abstract class TramiteEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTramite")
    private Long id;
    
    @Column(name = "tipo", insertable = false, updatable = false) // No se inserta ni actualiza en la tabla
    private String tipo;
    
    @Column(name = "costo", nullable = false)
    private int costo;
    
    @Column(name = "fechaTramite", nullable = false)
    @Temporal(TemporalType.DATE)
    private Calendar fechaTramite;
    
    @Column(name = "estado", nullable = false)
    private int estado;
    
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "idPersona")
    private PersonaEntidad persona;
    
    /**
     * Constructor por defecto
     */
    public TramiteEntidad() {
    }

    /**
     * Constructor que inicializa los parametro
     * @param costo
     * @param fechaTramite
     * @param persona
     * @param estado
     * @param tipo 
     */
    public TramiteEntidad(int costo, Calendar fechaTramite, PersonaEntidad persona, int estado, String tipo) {
        
        this.costo = costo;
        this.fechaTramite = fechaTramite;
        this.persona = persona;
        this.estado = estado;
        this.tipo = tipo;
    }

    /**
     * metodo que regresa el tipo de tramite
     * @return 
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * metodo que setea el tipo de tramite
     * @param tipo 
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * metodo que regresa el costo del tramite
     * @return 
     */
    public int getCosto() {
        return costo;
    }

    /**
     * metodo que regresa el estado del tramite
     * @return 
     */
    public int getEstado() {
        return estado;
    }

    /**
     * metodo que setea el estado del tramite
     * @param estado 
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }

    /**
     * metodo que setea el costo del tramite
     * @param costo 
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }

    /**
     * metodo que regresa la fecha del tramite
     * @return 
     */
    public Calendar getFechaTramite() {
        return fechaTramite;
    }

    /**
     * meotod que setea la fecha del tramite
     * @param fechaTramite 
     */
    public void setFechaTramite(Calendar fechaTramite) {
        this.fechaTramite = fechaTramite;
    }
    
    /**
     * metodo que regresa la persona que realizó el tramite
     * @return 
     */
    public PersonaEntidad getPersona() {
        return persona;
    }

    /**
     * metodo que regresa el id del tramite
     * @return 
     */
    public Long getId() {
        return id;
    }
    
    /**
     * metodo que setea la persona que realizó el tramite
     * @param cliente 
     */
    public void setPersona(PersonaEntidad cliente) {
        this.persona = cliente;
    }
    
    /**
     * metodo que regresa una lista de cadenas con los valores de cada atrbuto
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TramiteEntidad{");
        sb.append("id=").append(id);
        sb.append(", costo=").append(costo);
        sb.append(", fechaNacimiento=").append(fechaTramite);
        sb.append(", cliente=").append(persona);
        sb.append('}');
        return sb.toString();
    }
}
