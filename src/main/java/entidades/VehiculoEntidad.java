package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * 
 * @author Amós Helí Olguín Quiróz
 */
@Entity
public class VehiculoEntidad implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVehiculo")
    private Long idVehiculo;
    
    @Column(name = "color", nullable = false, length = 20)
    private String color;
    
    @Column(name = "linea", nullable = false, length = 40)
    private String linea;
    
    @Column(name = "marca", nullable = false, length = 40)
    private String marca;
    
    @Column(name = "modelo", nullable = false, length = 4)
    private String modelo;
    
    @Column(name = "numSerie", nullable = false, unique = true)
    private String numSerie;
    
    @OneToMany(mappedBy = "vehiculo", cascade = {CascadeType.PERSIST})
    private List <PlacaEntidad> placas;
    
    @ManyToOne
    @JoinColumn(name = "idPersona")
    private PersonaEntidad persona;

    /**
     * constructor por defecto
     */
    public VehiculoEntidad() {
    }

    /**
     * Constructor que inicializa los parametro
     * @param color
     * @param linea
     * @param marca
     * @param modelo
     * @param numSerie 
     */
    public VehiculoEntidad(String color, String linea, String marca, String modelo, String numSerie) {
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.modelo = modelo;
        this.numSerie = numSerie;
    }

    /**
     * metodo que rergresa el color del vehiculo
     * @return 
     */
    public String getColor() {
        return color;
    }

    /**
     * metodo que setea el color del vehiculo
     * @param color 
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * metodo que regresa la linea dle vehiculo
     * @return 
     */
    public String getLinea() {
        return linea;
    }

    /**
     * metodo que setea la linea del vehiculo
     * @param linea 
     */
    public void setLinea(String linea) {
        this.linea = linea;
    }

    /**
     * metro que regresa la marca del vehiculo
     * @return 
     */
    public String getMarca() {
        return marca;
    }

    /**
     * metodo que setea la marca del vehiculo
     * @param marca 
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * metodo que regresa el modelo del vehiculo 
     * @return 
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * metodo que setea el modleo del vehciulo
     * @param modelo 
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * metodo que regresa el numero de serie
     * @return 
     */
    public String getNumSerie() {
        return numSerie;
    }

    /**
     * metodo que setea el numero de serie
     * @param numSerie 
     */
    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    /**
     * metodo que regresa las placas del vehiculo
     * @return 
     */
    public List<PlacaEntidad> getPlacas() {
        return placas;
    }

    /**
     * metodo que setea las placas del vehiculo
     * @param placas 
     */
    public void setPlacas(List<PlacaEntidad> placas) {
        this.placas = placas;
    }

    /**
     * metodo que regresa la persona dueña del vehiculo
     * @return 
     */
    public PersonaEntidad getPersona() {
        return persona;
    }

    /**
     * metodo que setea la persona dueña del vehiculo
     * @param persona 
     */
    public void setPersona(PersonaEntidad persona) {
        this.persona = persona;
    }

    /**
     * metodo que regresa el id del vehiculo
     * @return 
     */
    public Long getIdVehiculo() {
        return idVehiculo;
    }

    /**
     * Metodo que genera una lista de string con los valores que contiene el 
     * mismo
     * @return string con datos
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(", color=").append(color);
        sb.append(", linea=").append(linea);
        sb.append(", marca=").append(marca);
        sb.append(", modelo=").append(modelo);
        sb.append(", numSerie=").append(numSerie);
        sb.append('}');
        return sb.toString();
    }
}
