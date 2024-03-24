package DTO;

import java.util.Calendar;

public class PersonaGeneradaDTO {
    
    private Long idPersona;
    private Calendar fechaNacimiento;
    private String rfc;
    private String curp;
    private boolean discapacidad;
    private String telefono;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;

    public PersonaGeneradaDTO() {
    }

    public PersonaGeneradaDTO(Long idPersona, String rfc, String curp, boolean discapacidad, String nombre, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String telefono) {
        
        this.idPersona = idPersona;
        this.rfc = rfc;
        this.curp = curp;
        this.discapacidad = discapacidad;
        this.nombres = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = telefono;
        
    }

    public Long getIdPersona() {
        return idPersona;
    }

    public String getCurp() {
        return curp;
    }

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setIdPersona(Long idPersona) {
        this.idPersona = idPersona;
    }
    
    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombres;
    }

    public void setNombre(String nombre) {
        this.nombres = nombre;
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

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PersonaGeneradaDTO{");
        sb.append("idPersona=").append(idPersona);
        sb.append(", rfc=").append(rfc);
        sb.append(", nombre=").append(nombres);
        sb.append(", apellidoPaterno=").append(apellidoPaterno);
        sb.append(", apellidoMaterno=").append(apellidoMaterno);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", telefono=").append(telefono);
        sb.append('}');
        return sb.toString();
    }

    

}
