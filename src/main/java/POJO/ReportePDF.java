package POJO;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import negocio.PersonaConsulta;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public class ReportePDF {
    
    private String nombres;
    private String nombreDeEncriptado;
    private Calendar fechaTramite;
    private String tipo;
    private int costo;
    private Date fechaTramiteDate;

    /**
     * Constructor que inicializa los valores dados como parametro
     * @param nombres
     * @param fechaTramite
     * @param tipo
     * @param costo 
     */
    public ReportePDF(String nombres, Calendar fechaTramite, String tipo, int costo) {
        PersonaConsulta persona = new PersonaConsulta();
        this.nombres = nombres;
        this.fechaTramite = fechaTramite;
        this.fechaTramiteDate = fechaTramite.getTime();
        this.nombreDeEncriptado = persona.desencriptar(nombres);
        this.tipo = tipo;
        this.costo = costo;
    }

    /**
     * Constructor por default
     */
    public ReportePDF() {
    }

    /**
     * metodo que regresa el nombre del autor del tramite
     * @return 
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * metodo que setea el nombre del autor del tramite
     * @param nombres 
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * metodo que regresa la fecha del tramite
     * @return 
     */
    public Calendar getFechaTramite() {
        return fechaTramite;
    }

    /**
     * metodo que regresa la fecha de tipo date para jasperreport
     * @return 
     */
    public Date getFechaTramiteDate(){
        return fechaTramite.getTime();
    }

    /**
     * metodo que regresa el nombre desencriptado para jasperreport
     * @return 
     */
    public String getNombreDeEncriptado() {
        PersonaConsulta persona = new PersonaConsulta();
        return persona.desencriptar(nombres);
    }

    /**
     * Metodo que setea el nombre desencriptado del reporte
     * @param nombreDeEncriptado 
     */
    public void setNombreDeEncriptado(String nombreDeEncriptado) {
        this.nombreDeEncriptado = nombreDeEncriptado;
    }
    
    /**
     * metodo que setea la fehca de tipo date para jasperreport
     * @param fechaTramiteDate 
     */
    public void setFechaTramiteDate(Date fechaTramiteDate){
        this.fechaTramiteDate = fechaTramiteDate;
    }
    
    /**
     * metodos setea la fecha del tramite
     * @param fechaTramite 
     */
    public void setFechaTramite(Calendar fechaTramite) {
        this.fechaTramite = fechaTramite;
    }
    
    /**
     * metodo que regresa el tipo de tramite
     * @return 
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * metodo que setea el tipo del tramite
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
     * metodo que setea el costo del tramite
     * @param costo 
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }

    /**
     * metodo que hashea el pdf para poder comparar
     * @return 
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nombres);
        hash = 37 * hash + Objects.hashCode(this.fechaTramite);
        hash = 37 * hash + Objects.hashCode(this.tipo);
        hash = 37 * hash + this.costo;
        return hash;
    }

    /**
     * metodo que compara un ReportePDF con otro
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ReportePDF other = (ReportePDF) obj;
        if (this.costo != other.costo) {
            return false;
        }
        if (!Objects.equals(this.nombres, other.nombres)) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        return Objects.equals(this.fechaTramite, other.fechaTramite);
    }
}