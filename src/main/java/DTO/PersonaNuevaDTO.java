/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Calendar;

/**
 *
 * @author Amos Heli Olguin Quiroz
 */
public class PersonaNuevaDTO {
    
    private Calendar fechaNacimiento;
    private String rfc;
    private String curp;
    private String telefono;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public PersonaNuevaDTO() {
    }

    public PersonaNuevaDTO(Calendar fechaNacimiento, String rfc, String curp, String telefono, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.fechaNacimiento = fechaNacimiento;
        this.rfc = rfc;
        this.curp = curp;
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PersonaNuevaDTO{");
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
