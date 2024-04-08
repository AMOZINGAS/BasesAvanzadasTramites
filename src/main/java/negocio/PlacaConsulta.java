package negocio;

import DAOS.IPlacaDAO;
import DAOS.IVehiculoDAO;
import DAOS.PlacaDAO;
import DAOS.VehiculoDAO;
import DTO.PlacaGeneradaDTO;
import DTO.PlacaNuevaDTO;
import DTO.VehiculoGeneradoDTO;
import entidades.PlacaEntidad;
import entidades.VehiculoEntidad;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import modificadores.Convertidor;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public class PlacaConsulta {
    
    private final IPlacaDAO placaDAO;
    
    /**
     * Constructor que inicializa una placa dao
     */
    public PlacaConsulta(){
        placaDAO = new PlacaDAO();
    }
    
    /**
     * Metodo que valida que una placa no este dentro del rango de validacion
     * @param placaGeneradaDTO
     * @return 
     */
    public PlacaGeneradaDTO validarVigenciaPlaca(PlacaGeneradaDTO placaGeneradaDTO){
        Calendar fechaActual = Calendar.getInstance();
        if(placaGeneradaDTO.getFechaTramite().get(Calendar.YEAR) == fechaActual.get(Calendar.YEAR)){
            JOptionPane.showMessageDialog(null, "No puedes renovar la placa\nPlaca valida todo este año (" + fechaActual.get(Calendar.YEAR) + ")", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
        }else{
            return placaGeneradaDTO;
        }
    }
     
    /**
     * Metodo que valida que el numero de la placa no exista
     * @return 
     */
    public String validarPlacaGenerada(){
        String placa;
        do{     
            placa = generarPlaca();     
        }while(buscarPlacaNumeroPlaca(placa)!=null); 
        return placa; 
    }
     
    /**
     * Metodo que genera una placa 
     * @return 
     */
    public String generarPlaca(){
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            char letraAleatoria = (char) (random.nextInt(26) + 'A');
            sb.append(letraAleatoria);
        }
        for (int i = 0; i < 3; i++) {
            int numeroAleatorio = random.nextInt(10);
            sb.append(numeroAleatorio);
        }
        return sb.toString();
    }
    
    /**
     * metodo que agrega a una placa un vehiculo
     * @param placaNuevaDTO
     * @param vehiculoGeneradoDTO
     * @return 
     */
    public PlacaNuevaDTO agregarVehiculo(PlacaNuevaDTO placaNuevaDTO, VehiculoGeneradoDTO vehiculoGeneradoDTO){
        try{
            IVehiculoDAO vehiculoDAO = new VehiculoDAO();
            Convertidor convertidor = new Convertidor();
            VehiculoEntidad vehiculoEntidad = vehiculoDAO.buscarPorNumeroSerie(vehiculoGeneradoDTO.getNumSerie());
            PlacaEntidad placaEntidad = placaDAO.buscarPorNumeroPlaca(placaNuevaDTO.getNumeroPlaca());
            placaDAO.agregarVehiculo(vehiculoEntidad, placaEntidad);
            return convertidor.entityToDTO(placaEntidad, new PlacaNuevaDTO());
        }catch(PersistenceException px){
            JOptionPane.showMessageDialog(null, "Ocurrió un error al agregarle un vehiculo a una placa", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    /**
     * metodo que actualiza la placa dada como parametro
     * @param placaGeneradaDTO
     * @return 
     */
    public PlacaGeneradaDTO actualizarPlaca(PlacaGeneradaDTO placaGeneradaDTO){
        try{
            Convertidor convertidor = new Convertidor();
            PlacaEntidad placaEntidad = placaDAO.buscarPorNumeroPlaca(placaGeneradaDTO.getNumeroPlaca());
            placaDAO.actualizarPlaca(placaEntidad);
            return convertidor.entityToDTO(placaEntidad, new PlacaGeneradaDTO());
        }catch(PersistenceException px){
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar placa", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    /**
     * Metodo que genera una lista de placa que tenga una vehiculo
     * @param numeroSerie
     * @return 
     */
    public List<PlacaGeneradaDTO> listaPlacaVehiculo(String numeroSerie){
        IVehiculoDAO vehiculoDAO = new VehiculoDAO();
        VehiculoEntidad vehiculoEntidad = vehiculoDAO.buscarPorNumeroSerie(numeroSerie);
        List<PlacaEntidad> listaEntidad = placaDAO.listaPlacasVehiculo(vehiculoEntidad);
        List<PlacaGeneradaDTO> listaPlacaDTO = new ArrayList<>();
        for(int i = 0; i < listaEntidad.size(); i ++){
            PlacaEntidad placa = listaEntidad.get(i);
            Convertidor convertidor = new Convertidor();
            PlacaGeneradaDTO placaGeneradaDTO = convertidor.entityToDTO(placa, new PlacaGeneradaDTO());
            listaPlacaDTO.add(placaGeneradaDTO);
        }
        return listaPlacaDTO;
    }
    
    /**
     * Metodo que busca una placa por su numero de placa
     * @param numeroPlaca
     * @return 
     */
    public PlacaGeneradaDTO buscarPlacaNumeroPlaca(String numeroPlaca){
        try{
            PlacaEntidad placaEntidad = placaDAO.buscarPorNumeroPlaca(numeroPlaca);
            Convertidor convertidor = new Convertidor();
            PlacaGeneradaDTO placaGeneradaDTO = convertidor.entityToDTO(placaEntidad, new PlacaGeneradaDTO());
            return placaGeneradaDTO;
        }catch(NoResultException nre){
            JOptionPane.showMessageDialog(null, "No se encontró una placa con ese numero de placa");
            return null;
        }
    }
}
