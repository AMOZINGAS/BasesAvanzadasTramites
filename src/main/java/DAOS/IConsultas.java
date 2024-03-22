/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOS;

//import Entidades.LicenciaEntidad;
//import Entidades.PlacaEntidad;
import entidades.LicenciaEntidad;
import entidades.PlacaEntidad;
import java.util.List;

/**
 *
 * @author elimo
 */
public interface IConsultas {
    
    List<LicenciaEntidad> buscarLicenciasPorCriterios(LicenciaEntidad licenciaEntidad);
    
    List<PlacaEntidad> buscarPlacasPorCriterios(PlacaEntidad placaEntidad);
    
}
