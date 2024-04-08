package DTO;

/**
 *
 * @author Amos Heli Olguin Quiroz
 */
public class VehiculoGeneradoDTO {
    
    private Long id;
    private String color;
    private String linea;
    private String marca;
    private String modelo;
    private String numSerie;
    

    /**
     * contrsuctor por defecto
     */
    public VehiculoGeneradoDTO() {
    }

    /**
     * Metodo que inicializa el vehiculo con los datos necesarios
     * @param id
     * @param color
     * @param linea
     * @param marca
     * @param modelo
     * @param numSerie 
     */
    public VehiculoGeneradoDTO(Long id, String color, String linea, String marca, String modelo, String numSerie) {
        this.id = id;
        this.color = color;
        this.linea = linea;
        this.marca = marca;
        this.modelo = modelo;
        this.numSerie = numSerie;
    }

    /**
     * metodo que regresa el id del vehiculo
     * @return 
     */
    public Long getId() {
        return id;
    }

    /**
     * metodo que regresa el color del vehiculo
     * @return 
     */
    public String getColor() {
        return color;
    }

    /**
     * metdoo que setea el color del vehiculo
     * @param color 
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * metodo que regresa la linea del vehiculo
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
     * metodo que regresa la marca del vehiculo
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
     * metodo que setea el modelo del vehiculo
     * @param modelo 
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * metodo que regresa el numero de serie del vehiculo
     * @return 
     */
    public String getNumSerie() {
        return numSerie;
    }

    /**
     * metodo que setea el numero de serie del vehiculo
     * @param numSerie 
     */
    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }
    
    /**
     * metodo que regresa una lista de cadenas con los valores de los atributos
     * @return 
     */
    @Override
    public String toString(){
        return linea + ".. " + marca + ".. " + numSerie + ".. " + modelo + ".. " + color;
    }
}