/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOS;

//import Entidades.LicenciaEntidad;
import entidades.LicenciaEntidad;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author elimo
 */
public interface ILicenciaDAO {
    
    void guardarLicenciaBD(LicenciaEntidad licenciaEntidad);
    List<LicenciaEntidad> buscarLicenciasPorNombre(String nombre);
    List<LicenciaEntidad> buscarLicenciaPorCURP(String curp);
    List<LicenciaEntidad> buscarLicenciasPorFechaNacimiento(Calendar fechaNacimiento);
    List<LicenciaEntidad> obtenerTodasLasLicencias();
    
}
