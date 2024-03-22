package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LicenciaEntidad extends TramiteEntidad implements Serializable {
    
    @Column(name = "vigencia", nullable = false)
    private int vigencia;
    
    @Column(name = "folio", nullable = false)
    private int folio;

    public LicenciaEntidad() {
    }

    public LicenciaEntidad(int vigencia, int folio) {
        this.vigencia = vigencia;
        this.folio = folio;
    }

    public int getVigencia() {
        return vigencia;
    }

    public void setVigencia(int vigencia) {
        this.vigencia = vigencia;
    }

    public int getFolio() {
        return folio;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LicenciaEntidad{");
        sb.append(", vigencia=").append(vigencia);
        sb.append('}');
        return sb.toString();
    }

}
