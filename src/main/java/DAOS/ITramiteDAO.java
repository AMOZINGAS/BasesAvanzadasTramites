/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOS;

import entidades.PersonaEntidad;
import entidades.TramiteEntidad;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author PC
 */
public interface ITramiteDAO {
    
    public List<TramiteEntidad> listaTramiterPersonaFecha(PersonaEntidad personaEntidad, Calendar fechaHasta, Calendar desde);
    
    public List<TramiteEntidad> listaTramitePersonaTipoFecha(PersonaEntidad personaEntidad, String tipo, Calendar fechaHasta, Calendar desde);
    
    public List<TramiteEntidad> listaTramite(String tipo);
    
}
