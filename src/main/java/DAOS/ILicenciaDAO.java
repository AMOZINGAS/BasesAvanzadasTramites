/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOS;

//import Entidades.LicenciaEntidad;
import entidades.LicenciaEntidad;
import entidades.PersonaEntidad;
import java.util.List;
/**
 *
 * @author elimo
 */
public interface ILicenciaDAO {
    
    public LicenciaEntidad agregarPersona(PersonaEntidad personaEntidad, LicenciaEntidad licenciaEntidad);
    
    public LicenciaEntidad actualizarLicencia(LicenciaEntidad licenciaEntidad);
    
    public LicenciaEntidad buscarLicenciaFolio(int folio);
    
    public List<LicenciaEntidad> listaLicenciaPersona(PersonaEntidad personaEntidad);
    
}
