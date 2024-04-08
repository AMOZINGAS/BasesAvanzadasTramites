/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import DAOS.IPersonaDAO;
import DAOS.IVehiculoDAO;
import DAOS.PersonaDAO;
import DAOS.VehiculoDAO;
import DTO.LicenciaNuevaDTO;
import DTO.PersonaGeneradaDTO;
import DTO.PersonaNuevaDTO;
import DTO.VehiculoGeneradoDTO;
import DTO.VehiculoNuevoDTO;
import entidades.LicenciaEntidad;
import entidades.PersonaEntidad;
import entidades.VehiculoEntidad;
import java.util.ArrayList;
//import Entidades.PersonaEntidad;
//import Entidades.VehiculoEntidad;
import java.util.Calendar;
import java.util.List;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;
import modificadores.Convertidor;

/**
 *
 * @author Amos Heli Olguin Quiroz
 */
public class PersonaConsulta {
    
    private final IPersonaDAO personaDAO;
    
    
    public PersonaConsulta(){
        
        personaDAO = new PersonaDAO();
    
    }
    
    /**
     * Metodo que llama a persistencia por una lista de las entidades persona
     * @return listaPersona
     */
    public List<PersonaGeneradaDTO> listaPersonas(){
        
        List<PersonaEntidad> listaPersonas = personaDAO.listaPersonas();
        List<PersonaGeneradaDTO> listaPersonasDTO = new ArrayList<>();
        for(int i = 0; i < listaPersonas.size(); i ++){
            
            PersonaEntidad persona = listaPersonas.get(i);
            Convertidor convertidor = new Convertidor();
            PersonaGeneradaDTO personaGeneradaDTO = convertidor.entityToDTO(persona, new PersonaGeneradaDTO());
            listaPersonasDTO.add(personaGeneradaDTO);
            
        }
        return listaPersonasDTO;
        
    }
    
    /**
     * Metodo que regresa una lista con las personas que coincidan con el nombre
     * @param nombres
     * @return listaPersonasNombre
     */
    public List<PersonaGeneradaDTO> listaPersonasNombre(String nombres){
        
        List<PersonaEntidad> listaPersonasNombre = personaDAO.buscarPorNombre(nombres);
        List<PersonaGeneradaDTO> listaPersonasDTO = new ArrayList<>();
        for(int i = 0; i < listaPersonasNombre.size(); i ++){
            
            PersonaEntidad persona = listaPersonasNombre.get(i);
            Convertidor convertidor = new Convertidor();
            PersonaGeneradaDTO personaGeneradaDTO = convertidor.entityToDTO(persona, new PersonaGeneradaDTO());
            listaPersonasDTO.add(personaGeneradaDTO);
            
        }
        return listaPersonasDTO;
        
    }
    
    public List<PersonaGeneradaDTO> listaPersonasNombreCurp(String nombre, String curp){
        
        List<PersonaEntidad> listaPersonasNombreCurp = personaDAO.buscarPorNombreCurp(nombre, curp);
        List<PersonaGeneradaDTO> listaPersonasDTO = new ArrayList<>();
        for(int i = 0; i < listaPersonasNombreCurp.size(); i ++){
            
            PersonaEntidad persona = listaPersonasNombreCurp.get(i);
            Convertidor convertidor = new Convertidor();
            PersonaGeneradaDTO personaGeneradaDTO = convertidor.entityToDTO(persona, new PersonaGeneradaDTO());
            listaPersonasDTO.add(personaGeneradaDTO);
            
        }
        return listaPersonasDTO;
        
    }
    
    /**
     * Metodo que regresa un dto de una persona buscada por su id
     * @param id
     * @return personaGeneradaDTO
     */
    public PersonaGeneradaDTO personaPorID(Long id) throws NoResultException{
        
        try{
            
            PersonaEntidad personaEntidad = personaDAO.buscarPorId(id);
            Convertidor convertidor = new Convertidor();
            PersonaGeneradaDTO personaGeneradaDTO = convertidor.entityToDTO(personaEntidad, new PersonaGeneradaDTO());
            return personaGeneradaDTO;
            
        }catch(NoResultException nre){
            
            JOptionPane.showMessageDialog(null, "No se encontró una persona con ese id");
            return null;
            
        }
        
       
    }
    
    /**
     * Metodo que convierte un dto a entidad para buscar la curp de dicha entidad
     * @param curp
     * @return personageneradadto
     * @throws NoResultException 
     */
    public PersonaGeneradaDTO personaPorCurp(String curp) throws NoResultException{
        
         try{
            
            PersonaEntidad personaEntidad = personaDAO.buscarPorCurp(curp);
            Convertidor convertidor = new Convertidor();
            PersonaGeneradaDTO personaGeneradaDTO = convertidor.entityToDTO(personaEntidad, new PersonaGeneradaDTO());
            return personaGeneradaDTO;
            
        }catch(NoResultException nre){
            
            JOptionPane.showMessageDialog(null, "No se encontró una persona con esa curp");
            return null;
            
        }
        
    }
    
    /**
     * Metodo que regresa un dto que fue enviado a persistir
     * @param personaNuevaDTO
     * @return personaGeneradaDTO
     */
    public PersonaGeneradaDTO agregarPersona(PersonaNuevaDTO personaNuevaDTO){
        
        Convertidor convertidor = new Convertidor();
        PersonaEntidad personaEntidad = convertidor.DTOToEntidad(personaNuevaDTO, new PersonaEntidad());
        personaEntidad = personaDAO.agregarPersona(personaEntidad);
        PersonaGeneradaDTO personaGeneradaDTO = convertidor.entityToDTO(personaEntidad, new PersonaGeneradaDTO());
        return personaGeneradaDTO;
        
    }
    
    /**
     * Metodo que agrega 20 personas a la base de datos de manera masiva y para
     * ejemplos
     */
    public void agregarMasivoPersonas(){
        
        Calendar fechaNacimiento = Calendar.getInstance();
        fechaNacimiento.set(2004, 3, 9);
        PersonaEntidad persona1 = new PersonaEntidad(fechaNacimiento, "OUQ090304QF7", "OUQA040309HSRLRMA5", false, "6442621169", "Amos Heli", "Olguin", "Quiroz");
        personaDAO.agregarPersona(persona1);
        Calendar fechaNacimiento2 = Calendar.getInstance();
        fechaNacimiento2.set(2000, 6, 3);
        PersonaEntidad persona2 = new PersonaEntidad(fechaNacimiento2, "QAUW283743", "AQWN090238HSRLRMA5", false, "6441627193", "Juan Luis", "Robles", "Sanchez");
        personaDAO.agregarPersona(persona2);
        Calendar fechaNacimiento3 = Calendar.getInstance();                                      
        fechaNacimiento3.set(1990, 9, 1);
        PersonaEntidad persona3 = new PersonaEntidad(fechaNacimiento3, "AJKWI29873", "QOJA932837HSRLRMA5", false, "6352817263", "Hector", "Kino", "Suarez");
        personaDAO.agregarPersona(persona3);
        Calendar fechaNacimiento4 = Calendar.getInstance();
        fechaNacimiento4.set(2004, 9, 20);
        PersonaEntidad persona4 = new PersonaEntidad(fechaNacimiento4, "MASM040920QF6", "MASM040920HSRLRMA5", false, "6444579590", "Michelle", "Medina", "Sepulveda");
        personaDAO.agregarPersona(persona4);
        Calendar fechaNacimiento5 = Calendar.getInstance();
        fechaNacimiento5.set(2001, 4, 30);
        PersonaEntidad persona5 = new PersonaEntidad(fechaNacimiento5, "8273HSNA", "ALSIJOIW2323", true, "6464287541", "Maicol", "Mayers", "Hallowen");
        personaDAO.agregarPersona(persona5);
        Calendar fechaNacimiento6 = Calendar.getInstance();
        fechaNacimiento6.set(1982, 6, 15);
        PersonaEntidad persona6 = new PersonaEntidad(fechaNacimiento6, "OIUEW873", "KJNASI7Q7823", true, "6444827362", "Pedro", "De la Rosa", "Valle");
        personaDAO.agregarPersona(persona6);
        Calendar fechaNacimiento7 = Calendar.getInstance();
        fechaNacimiento7.set(1970, 12, 12);
        PersonaEntidad persona7 = new PersonaEntidad(fechaNacimiento7, "ASJN2733", "8NWWE83NSDAW", false, "6443872911", "Sergio Michel", "Perez", "Mendoza");
        personaDAO.agregarPersona(persona7);
        Calendar fechaNacimiento8 = Calendar.getInstance();
        fechaNacimiento8.set(2003, 1, 19);
        PersonaEntidad persona8 = new PersonaEntidad(fechaNacimiento8, "HASFGW23", "KANJSUWUW334", false, "6352837422", "Carlos", "Sains", "Vasquez");
        personaDAO.agregarPersona(persona8);
        Calendar fechaNacimiento9 = Calendar.getInstance();
        fechaNacimiento9.set(1975, 12, 30);
        PersonaEntidad persona9 = new PersonaEntidad(fechaNacimiento9, "H1QALO93", "POQA0987293L", false, "6483029384", "Valteri", "Bottas", "Kali");
        personaDAO.agregarPersona(persona9);
        Calendar fechaNacimiento10 = Calendar.getInstance();
        fechaNacimiento10.set(2004, 7, 6);
        PersonaEntidad persona10 = new PersonaEntidad(fechaNacimiento10, "IAJW8223", "IAJWUW8339KK", false, "6463728354", "Olliver", "Inzunza", "Valle");
        personaDAO.agregarPersona(persona10);
        Calendar fechaNacimiento11 = Calendar.getInstance();
        fechaNacimiento11.set(2000, 6, 13);
        PersonaEntidad persona11 = new PersonaEntidad(fechaNacimiento11, "AOWIBSD8", "PUEJ000613HSRLRMA5", false, "6441613092", "Jullian Herlenn", "Puerta", "sin apellido");
        personaDAO.agregarPersona(persona11);
       Calendar fechaNacimiento12 = Calendar.getInstance();
        fechaNacimiento12.set(205, 5, 5);
        PersonaEntidad persona12 = new PersonaEntidad(fechaNacimiento12, "AOIEW932", "JNASUNWUE7373NNASA", true, "6425364758", "Kamila", "Nuñez", "Lopez");
        personaDAO.agregarPersona(persona12);
       Calendar fechaNacimiento13 = Calendar.getInstance();
        fechaNacimiento13.set(2004, 3, 9);
        PersonaEntidad persona13 = new PersonaEntidad(fechaNacimiento13, "SJAJSU8A", "OAUE039485HNSHSNAU", false, "6442562435", "Jocelyn", "Lopez", "Vega");
        personaDAO.agregarPersona(persona13);
        Calendar fechaNacimiento14 = Calendar.getInstance();
        fechaNacimiento14.set(1990, 7, 23);
        PersonaEntidad persona14 = new PersonaEntidad(fechaNacimiento14, "AHNBYW33", "AMNSIENU873483DMSN", false, "6443265227", "Francisco", "Valdez", "Gastelum");
        personaDAO.agregarPersona(persona14);
        Calendar fechaNacimiento15 = Calendar.getInstance();
        fechaNacimiento15.set(1940, 9, 25);
        PersonaEntidad persona15 = new PersonaEntidad(fechaNacimiento15, "MSAIMSIW", "HSDABSNBANBSUIEW3S", false, "6432728394", "Marty", "McFly", "sin apellido");
        personaDAO.agregarPersona(persona15);
        Calendar fechaNacimiento16 = Calendar.getInstance();
        fechaNacimiento16.set(2004, 11, 19);
        PersonaEntidad persona16 = new PersonaEntidad(fechaNacimiento16, "AHNUEDAE", "JANYWSNYDBTEYWEASW", true, "6473920903", "Hector", "Salamanca", "Lopez");
        personaDAO.agregarPersona(persona16);
       Calendar fechaNacimiento17 = Calendar.getInstance();
        fechaNacimiento17.set(1939, 2, 20);
        PersonaEntidad persona17 = new PersonaEntidad(fechaNacimiento17, "AAAAÑSLS", "SJKNDEUINUWI8E34DS", false, "6343828329", "James Morgan", "McGill", "sin apellido");
        personaDAO.agregarPersona(persona17);
        Calendar fechaNacimiento18 = Calendar.getInstance();
        fechaNacimiento18.set(1999, 11, 11);
        PersonaEntidad persona18 = new PersonaEntidad(fechaNacimiento18, "AKSLALIE", "KINAMSOIUWWPEOWPDS", false, "5353674829", "Edgar Alonso", "Panduro", "Jocobi");
        personaDAO.agregarPersona(persona18);
       Calendar fechaNacimiento19 = Calendar.getInstance();
        fechaNacimiento19.set(1998, 7, 12);
        PersonaEntidad persona19 = new PersonaEntidad(fechaNacimiento19, "JSDNUEND", "LAÑSÑOAEUERYRBASKS", true, "4253728191", "Michael Gary", "Scott", "sin apellido");
        personaDAO.agregarPersona(persona19);
        Calendar fechaNacimiento20 = Calendar.getInstance();
        fechaNacimiento20.set(1969, 5, 20);
        PersonaEntidad persona20 = new PersonaEntidad(fechaNacimiento20, "ALLAKSIE", "PAOAOSUEUDHBEBCHSA", false, "2893823474", "Michael", "Schumacher", "sin apellido");
        personaDAO.agregarPersona(persona20);
        
        
    }
    
    /**
     * Metodo que agrega un vehiculo a la lista de vehiculos de una persona
     * @param vehiculoNuevoDTO
     * @param personaGeneradaDTO
     * @return persona generada con el vehiculo en su lista
     */
    public PersonaGeneradaDTO agregarVehiculo(VehiculoNuevoDTO vehiculoNuevoDTO, PersonaGeneradaDTO personaGeneradaDTO) throws PersistenceException{
        
        try{
            
            Convertidor convertidor = new Convertidor();
            VehiculoEntidad vehiculoEntidad = convertidor.DTOToEntidad(vehiculoNuevoDTO, new VehiculoEntidad());
            PersonaEntidad personaEntidad = personaDAO.buscarPorId(personaGeneradaDTO.getIdPersona());
            personaEntidad = personaDAO.agregarVehiculo(vehiculoEntidad, personaEntidad);
            personaGeneradaDTO = convertidor.entityToDTO(personaEntidad, new PersonaGeneradaDTO());
            
            return personaGeneradaDTO;
            
        }catch(PersistenceException ex){
            
            JOptionPane.showMessageDialog(null, "Ocurrió un error al agregar vehiculo", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    /**
     * Metodo que actualiza a persona ya generada
     * @param personaGeneradaDTO
     * @return personaGeneradaDTO
     * @throws PersistenceException 
     */
    public PersonaGeneradaDTO actualizarPersona(PersonaGeneradaDTO personaGeneradaDTO) throws PersistenceException{
        
        try{
            
            Convertidor convertidor = new Convertidor();
            System.out.println("a");
            PersonaEntidad personaEntidad = personaDAO.buscarPorId(personaGeneradaDTO.getIdPersona());
            System.out.println("a");
            personaDAO.actualizarPersona(personaEntidad);
            System.out.println("a");
            return convertidor.entityToDTO(personaEntidad, new PersonaGeneradaDTO());
            
        }catch(PersistenceException px){
            
            JOptionPane.showMessageDialog(null, "Ocurrió un error al actualizar persona", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
            
        }
        
        
    }
    
    public boolean verificarLicencia(PersonaGeneradaDTO personaGeneradaDTO){
        
        PersonaEntidad personaEntidad = personaDAO.buscarPorId(personaGeneradaDTO.getIdPersona());
        if(personaEntidad.getLicencia().size()==0){
            
            System.out.println("TAMAÑO 0");
            return false;
            
        }else if(personaEntidad.getLicencia().get(personaEntidad.getLicencia().size()-1).getEstado()==0){
            
            return false;
            
        }
        return true;
        
    }
    
    public PersonaGeneradaDTO agregarLicencia(LicenciaNuevaDTO licenciaNuevoDTO, PersonaGeneradaDTO personaGeneradaDTO) throws PersistenceException{
        
        try{
            
            Convertidor convertidor = new Convertidor();
            LicenciaEntidad licenciaEntidad = new LicenciaEntidad();
            licenciaEntidad.setCosto(licenciaNuevoDTO.getCosto());
            licenciaEntidad.setEstado(licenciaNuevoDTO.getEstado());
            licenciaEntidad.setFechaTramite(licenciaNuevoDTO.getFechaTramite());
            licenciaEntidad.setVigencia(licenciaNuevoDTO.getVigencia());
            licenciaEntidad.setFolio(licenciaNuevoDTO.getFolio());
            PersonaEntidad personaEntidad = personaDAO.buscarPorId(personaGeneradaDTO.getIdPersona());
            licenciaEntidad.setPersonaLicencia(personaEntidad);
            personaEntidad = personaDAO.agregarLicencia(licenciaEntidad, personaEntidad);
            personaGeneradaDTO = convertidor.entityToDTO(personaEntidad, new PersonaGeneradaDTO());
            
            return personaGeneradaDTO;
            
        }catch(PersistenceException ex){
            
            JOptionPane.showMessageDialog(null, "Ocurrió un error al agregar la licencia", "ERROR!!", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
}
