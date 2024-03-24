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
    
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "idPersona")
    private PersonaEntidad persona;

    /**
     * constructor por defecto
     */
    public VehiculoEntidad() {
    }

    /**
     * Metodo que inicializa la entidad con los datos necesarios
     * @param color
     * @param linea
     * @param marca
     * @param modelo
     * @param numSerie 
     */
    public VehiculoEntidad(String color, String linea, String marca, String modelo, String numSerie, PersonaEntidad persona) {
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.modelo = modelo;
        this.numSerie = numSerie;
        this.persona = persona;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLinea() {
        return linea;
    }

    public void setLinea(String linea) {
        this.linea = linea;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public List<PlacaEntidad> getPlacas() {
        return placas;
    }

    public void setPlacas(List<PlacaEntidad> placas) {
        this.placas = placas;
    }

    public PersonaEntidad getPersona() {
        return persona;
    }

    public void setPersona(PersonaEntidad persona) {
        this.persona = persona;
    }

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
