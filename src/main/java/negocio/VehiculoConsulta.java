package negocio;

import DAOS.IPersonaDAO;
import DAOS.IVehiculoDAO;
import DAOS.PersonaDAO;
import DAOS.VehiculoDAO;
import DTO.PersonaGeneradaDTO;
import DTO.PlacaNuevaDTO;
import DTO.VehiculoGeneradoDTO;
import DTO.VehiculoNuevoDTO;
import entidades.PersonaEntidad;
import entidades.PlacaEntidad;
import entidades.VehiculoEntidad;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import modificadores.Convertidor;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public class VehiculoConsulta {
    
    IVehiculoDAO vehiculoDAO;
    
    /**
     * Constructor que inicializa el vehicuo dao
     */
    public VehiculoConsulta(){
        vehiculoDAO = new VehiculoDAO();
    }
    
    /**
     * metodo que verifica que el vehiculo sea nuevo
     * @param vehiculoGeneradoDTO
     * @return 
     */
    public boolean verificarNuevo(VehiculoGeneradoDTO vehiculoGeneradoDTO){
        VehiculoEntidad vehiculoEntidad = vehiculoDAO.buscarPorNumeroSerie(vehiculoGeneradoDTO.getNumSerie());
        if(vehiculoEntidad.getPlacas().size() == 0){
            return true;
        }
        return false;
    }
    
    /**
     * metodo que generea una lista de vehiculo dependiendo de las personas
     * que coincidan con la curp dada como parametro
     * @param curp
     * @return 
     */
    public List<VehiculoGeneradoDTO> listaVehiculosPersona(String curp){
        PersonaConsulta personaConsulta = new PersonaConsulta();
        PersonaGeneradaDTO personaGeneradaDTO = personaConsulta.personaPorCurp(curp);
        IVehiculoDAO vehiculoDAO = new VehiculoDAO();
        IPersonaDAO personaDAO = new PersonaDAO();
        PersonaEntidad personaEntidad = personaDAO.buscarPorId(personaGeneradaDTO.getIdPersona());
        List<VehiculoEntidad> listaEntidad = vehiculoDAO.listaVehiculoPersona(personaEntidad);
        List<VehiculoGeneradoDTO> listaVehiculoDTO = new ArrayList<>();
        for(int i = 0; i < listaEntidad.size(); i ++){
            VehiculoEntidad vehiculo = listaEntidad.get(i);
            Convertidor convertidor = new Convertidor();
            VehiculoGeneradoDTO vehiculoGeneradoDTO = convertidor.entityToDTO(vehiculo, new VehiculoGeneradoDTO());
            listaVehiculoDTO.add(vehiculoGeneradoDTO);
        }
        return listaVehiculoDTO;
    }
    
    /**
     * metodo que agrega una placa dada como parametro al vehiculo dado como parametro
     * @param vehiculoGeneradoDTO
     * @param placaNuevaDTO
     * @return 
     */
    public VehiculoGeneradoDTO agregarPlaca(VehiculoGeneradoDTO vehiculoGeneradoDTO, PlacaNuevaDTO placaNuevaDTO){
        try{
            Convertidor convertidor = new Convertidor();
            PlacaEntidad placaEntidad = new PlacaEntidad();
            placaEntidad.setCosto(placaNuevaDTO.getCosto());
            placaEntidad.setFechaTramite(placaNuevaDTO.getFechaTramite());
            placaEntidad.setNumeroPlaca(placaNuevaDTO.getNumeroPlaca());
            VehiculoEntidad vehiculoEntidad = vehiculoDAO.buscarPorNumeroSerie(vehiculoGeneradoDTO.getNumSerie());
            placaEntidad.setVehiculo(vehiculoEntidad);
            placaEntidad.setEstado(1);
            placaEntidad.setPersona(vehiculoEntidad.getPersona());
            vehiculoEntidad = vehiculoDAO.agregarPlaca(placaEntidad, vehiculoEntidad);
            vehiculoGeneradoDTO = convertidor.entityToDTO(vehiculoEntidad, new VehiculoGeneradoDTO());
            return vehiculoGeneradoDTO;
        }catch(PersistenceException ex){
            JOptionPane.showMessageDialog(null, "Ocurrió un error al agregar una placa", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    } 
    
    /**
     * metodo que actualiza al vehiculo dado como parametro
     * @param vehiculoGeneradoDTO
     * @return 
     */
    public VehiculoGeneradoDTO actualizarVehiculo(VehiculoGeneradoDTO vehiculoGeneradoDTO){
        try{
            Convertidor convertidor = new Convertidor();
            VehiculoEntidad vehiculoEntidad = vehiculoDAO.buscarPorNumeroSerie(vehiculoGeneradoDTO.getNumSerie());
            vehiculoDAO.actualizarVehiculo(vehiculoEntidad);
            return convertidor.entityToDTO(vehiculoEntidad, new VehiculoGeneradoDTO());
        }catch(PersistenceException px){
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar persona", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    /**
     * metodo que busca un vehiculo que coincida con el numero de serie dado
     * como parametro
     * @param numeroSerie
     * @return
     * @throws NoResultException 
     */
    public VehiculoGeneradoDTO buscarVehiculoNumeroSerie(String numeroSerie) throws NoResultException{
        try{
            VehiculoEntidad vehiculoEntidad = vehiculoDAO.buscarPorNumeroSerie(numeroSerie);
            Convertidor convertidor = new Convertidor();
            VehiculoGeneradoDTO vehiculoGeneradaDTO = convertidor.entityToDTO(vehiculoEntidad, new VehiculoGeneradoDTO());
            return vehiculoGeneradaDTO;
        }catch(NoResultException nre){
            JOptionPane.showMessageDialog(null, "No se encontró un vehiculo con ese numero de serie");
            return null;
        }
    }
    
    /**
     * metodo que busca al vehiculo que coincida con el numero de serei y este
     * dentro de la lista dados como parametros
     * @param listaVehiculos
     * @param numeroSerie
     * @return 
     */
    public VehiculoGeneradoDTO vehiculoPorPersona(List<VehiculoGeneradoDTO> listaVehiculos, String numeroSerie){
        for(int i = 0; i < listaVehiculos.size(); i ++){
            if(listaVehiculos.get(i).getNumSerie().equalsIgnoreCase(numeroSerie)){
                return listaVehiculos.get(i);
            }
        }
        return null;
    }
    
    /**
     * metodo que agrega un dueño a un vehiclo
     * @param vehiculoNuevoDTO
     * @param personaGeneradaDTO
     * @return
     * @throws PersistenceException 
     */
    public VehiculoNuevoDTO agregarPersona(VehiculoNuevoDTO vehiculoNuevoDTO, PersonaGeneradaDTO personaGeneradaDTO) throws PersistenceException{
        try{
            PersonaDAO personaDAO = new PersonaDAO();
            Convertidor convertidor = new Convertidor();
            PersonaEntidad personaEntidad = personaDAO.buscarPorId(personaGeneradaDTO.getIdPersona());
            VehiculoEntidad vehiculoEntidad = vehiculoDAO.buscarPorNumeroSerie(vehiculoNuevoDTO.getNumSerie());
            vehiculoDAO.agregarPersona(vehiculoEntidad, personaEntidad);
            return convertidor.entityToDTO(vehiculoEntidad, new VehiculoNuevoDTO());
        }catch(PersistenceException px){
            JOptionPane.showMessageDialog(null, "Ocurrió un error al agregarle una persona a vehiculo", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}