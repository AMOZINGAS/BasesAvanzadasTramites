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
    private boolean discapacidad;
    private String telefono;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;

    /**
     * Constructor por defecto
     */
    public PersonaNuevaDTO() {
    }

    /**
     * Metodo que inicializa los atributos dados como parametros
     * @param rfc
     * @param curp
     * @param discapacidad
     * @param nombres
     * @param apellidoPaterno
     * @param apellidoMaterno
     * @param fechaNacimiento
     * @param telefono 
     */
    public PersonaNuevaDTO(Calendar fechaNacimiento, String rfc, String curp, boolean discapacidad, String telefono, String nombres, String apellidoPaterno, String apellidoMaterno) {
        this.fechaNacimiento = fechaNacimiento;
        this.rfc = rfc;
        this.curp = curp;
        this.discapacidad = discapacidad;
        this.telefono = telefono;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * metodo que regresa la curp de la persona
     * @return 
     */
    public String getCurp() {
        return curp;
    }

    /**
     * metodo que regresa la discapacidad de la persona
     * @return 
     */
    public boolean isDiscapacidad() {
        return discapacidad;
    }

    /**
     * metodo que setea la discapacidad de la persona
     * @param discapacidad 
     */
    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }

    /**
     * metodo que setea la curp de la persona
     * @param curp 
     */
    public void setCurp(String curp) {
        this.curp = curp;
    }

    /**
     * metodo que regresa los nombre de la persona
     * @return 
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * metodo que setea los nombres de la persona
     * @param nombres 
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    
    /**
     * metodo que regresa el rfc de la persona
     * @return 
     */
    public String getRfc() {
        return rfc;
    }

    /**
     * metodoo que setea el rfc de la persona
     * @param rfc 
     */
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    /**
     * metodo que regresa el apellido paterno de la persona
     * @return 
     */
    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    /**
     * metodo que setea el apellido paterno de la persona
     * @param apellidoPaterno 
     */
    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    /**
     * metodo que regresa el apellido materno de la persona
     * @return 
     */
    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    /**
     * metodo que setea el apellido materno de la persona
     * @param apellidoMaterno 
     */
    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    /**
     * metodo que regresa la fecha de nacimiento de la persona
     * @return 
     */
    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * metodo que setea la fecha de nacimiento de la persona
     * @param fechaNacimiento 
     */
    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * metodo que regresa el telefono de la persona
     * @return 
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * metodo que setea el telefono de la persona
     * @param telefono 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * metodo que regresa una lista de cadenas con los valores de todos los
     * atributos de la clse
     * @return 
     */
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
