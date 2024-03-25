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

    public PersonaGeneradaDTO(Long idPersona, String rfc, String curp, boolean discapacidad, String nombres, String apellidoPaterno, String apellidoMaterno, Calendar fechaNacimiento, String telefono) {
        
        this.idPersona = idPersona;
        this.rfc = rfc;
        this.curp = curp;
        this.discapacidad = discapacidad;
        this.nombres = nombres;
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
        
        return nombres + " " +
               apellidoPaterno + " " +
               apellidoMaterno + " " +
               rfc + " " +
               curp + " " +
               fechaNacimiento.get(Calendar.DAY_OF_MONTH) + "/" + fechaNacimiento.get(Calendar.MONTH) + "/" + fechaNacimiento.get(Calendar.YEAR) + " " +
               telefono + " " +
               discapacidad;
    }

    

}
