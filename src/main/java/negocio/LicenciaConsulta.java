package negocio;

import DAOS.ILicenciaDAO;
import DAOS.IPersonaDAO;
import DAOS.LicenciaDAO;
import DAOS.PersonaDAO;
import DTO.LicenciaGeneradaDTO;
import DTO.LicenciaNuevaDTO;
import DTO.PersonaGeneradaDTO;
import entidades.LicenciaEntidad;
import entidades.PersonaEntidad;
import java.util.ArrayList;
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
public class LicenciaConsulta {
    
    ILicenciaDAO licenciaDAO;
    
    /**
     * Constructor que inicializa la licenciaDAO
     */
    public LicenciaConsulta(){
        
        licenciaDAO = new LicenciaDAO();
    
    }   
    
    /**
     * Metodo que agrega una persona a la licencia
     * @param licenciaNuevaDTO
     * @param personaGeneradaDTO
     * @return la licencia con la persona enlazada
     */
    public LicenciaNuevaDTO agregarPersona(LicenciaNuevaDTO licenciaNuevaDTO, PersonaGeneradaDTO personaGeneradaDTO){
        try{
            Convertidor convertidor = new Convertidor();
            IPersonaDAO personaDAO = new PersonaDAO();
            PersonaEntidad personaEntidad = personaDAO.buscarPorId(personaGeneradaDTO.getIdPersona());
            LicenciaEntidad licenciaEntidad = licenciaDAO.buscarLicenciaFolio(licenciaNuevaDTO.getFolio());
            System.out.println(licenciaEntidad.getFolio());
            licenciaDAO.agregarPersona(personaEntidad, licenciaEntidad);
            return  convertidor.entityToDTO(licenciaEntidad, new LicenciaNuevaDTO());
        }catch(PersistenceException px){   
            JOptionPane.showMessageDialog(null, "Ocurrió un error al agregarle un vehiculo a una placa", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;     
        }
    }
    
    /**
     * Metodo que grenera el folio para la licencia
     * @return un entero con el folio 
     */
    public int generarFolio(){
        
        Random random = new Random();
        int folio = random.nextInt(100000000);
        System.out.println(folio);
        return folio;
        
    }
    
    /**
     * metodo que verifica que el folio no este repetido
     * @return un entero con el folio
     */
    public int verificarFolio(){
        int folio;
        do{ 
            folio = generarFolio();
            System.out.println(folio); 
        }while(buscarLicenciaFolio(folio)!=null);
        return folio;
    }
     
    /**
     * Metodo que actualiza la licencia
     * @param licenciaGeneradaDTO
     * @return la licencia actualizada
     */
    public LicenciaGeneradaDTO actualizarLicencia(LicenciaGeneradaDTO licenciaGeneradaDTO){
        try{
            Convertidor convertidor = new Convertidor();
            LicenciaEntidad licenciaEntidad = licenciaDAO.buscarLicenciaFolio(licenciaGeneradaDTO.getFolio());
            licenciaDAO.actualizarLicencia(licenciaEntidad);
            return convertidor.entityToDTO(licenciaEntidad, new LicenciaGeneradaDTO());
        }catch(PersistenceException px){
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar placa", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    /**
     * Metodo que crea una lista dto de las persona que contengas esa licencia
     * @param curp
     * @return la lista de llicencia dto
     */
    public List<LicenciaGeneradaDTO> listaLicenciaPersona(String curp){
        IPersonaDAO personaDAO = new PersonaDAO();
        PersonaEntidad personaEntidad = personaDAO.buscarPorCurp(curp);
        List<LicenciaEntidad> listaEntidad = licenciaDAO.listaLicenciaPersona(personaEntidad);
        List<LicenciaGeneradaDTO> listaLicenciaDTO = new ArrayList<>();
        for(int i = 0; i < listaEntidad.size(); i ++){
            LicenciaEntidad licencia = listaEntidad.get(i);
            Convertidor convertidor = new Convertidor();
            LicenciaGeneradaDTO licenciaGeneradaDTO = convertidor.entityToDTO(licencia, new LicenciaGeneradaDTO());
            listaLicenciaDTO.add(licenciaGeneradaDTO);
        }
        return listaLicenciaDTO;
    }
    
    /**
     * Metodo que busca una licencia por folio dado como parametro
     * @param folio
     * @return la licencia encontrada, null en caso contrario
     */
    public LicenciaGeneradaDTO buscarLicenciaFolio(int folio){
        try{
            LicenciaEntidad licenicaEntidad = licenciaDAO.buscarLicenciaFolio(folio);
            if(licenicaEntidad==null){
                return null;
            }
            Convertidor convertidor = new Convertidor();
            LicenciaGeneradaDTO licenciaGeneradaDTO = convertidor.entityToDTO(licenicaEntidad, new LicenciaGeneradaDTO());
            return licenciaGeneradaDTO;
        }catch(NoResultException nre){
            JOptionPane.showMessageDialog(null, "No se encontró una placa con ese numero de placa");
            return null;
        }
    }
    
    /**
     * Metodo que busca una licencia por su id
     * @param id
     * @return la licencia encontrada null en caso contrario
     */
    public LicenciaGeneradaDTO buscarLicenciaId(Long id){
        try{
            LicenciaEntidad licenicaEntidad = licenciaDAO.buscarLicenciaId(id);
            if(licenicaEntidad==null){
                return null;
            }
            LicenciaGeneradaDTO licenciaGeneradaDTO = new LicenciaGeneradaDTO();
            licenciaGeneradaDTO.setCosto(licenicaEntidad.getCosto());
            System.out.println("Costo: " + licenciaGeneradaDTO.getCosto());
            licenciaGeneradaDTO.setEstado(licenicaEntidad.getEstado());
            System.out.println("Estado: " + licenciaGeneradaDTO.getEstado());
            licenciaGeneradaDTO.setFechaTramite(licenicaEntidad.getFechaTramite());
            System.out.println("Fecha: " + licenciaGeneradaDTO.getFechaTramite());
            licenciaGeneradaDTO.setFolio(licenicaEntidad.getFolio());
            System.out.println("Folio: " + licenciaGeneradaDTO.getFolio());
            licenciaGeneradaDTO.setId(licenicaEntidad.getId());
            System.out.println("Id: " + licenciaGeneradaDTO.getId());
            licenciaGeneradaDTO.setVigencia(licenicaEntidad.getVigencia());
            System.out.println("Vigencia: " + licenciaGeneradaDTO.getVigencia());
            return licenciaGeneradaDTO;
        }catch(NoResultException nre){
            JOptionPane.showMessageDialog(null, "No se encontró una placa con ese numero de placa");
            return null;
        }
    }
}
