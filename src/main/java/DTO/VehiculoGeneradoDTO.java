/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

    public Long getId() {
        return id;
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
    
    @Override
    public String toString(){
        
        return linea + ".. " + marca + ".. " + numSerie + ".. " + modelo + ".. " + color;
        
    }
    
}
