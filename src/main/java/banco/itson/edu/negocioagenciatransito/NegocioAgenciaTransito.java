/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package banco.itson.edu.negocioagenciatransito;

import DAOS.IPersonaDAO;
import DAOS.ITramiteDAO;
import DAOS.PersonaDAO;
import DAOS.TramiteDAO;
import DTO.PersonaGeneradaDTO;
import DTO.PersonaNuevaDTO;
import DTO.TramiteDTO;
import DTO.VehiculoGeneradoDTO;
import DTO.VehiculoNuevoDTO;
import entidades.PersonaEntidad;
import entidades.TramiteEntidad;
//import Entidades.PersonaEntidad;
//import Entidades.VehiculoEntidad;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modificadores.Convertidor;
import negocio.PersonaConsulta;
import negocio.PersonaVehiculoAgregar;
import negocio.TramiteConsulta;

/**
 *
 * @author elimo
 */
public class NegocioAgenciaTransito {

    public static void main(String[] args) {
        
        
//        TramiteConsulta tramiteConsulta = new TramiteConsulta();
//        PersonaEntidad persona = new PersonaEntidad();
//        IPersonaDAO personaDAO = new PersonaDAO();
//        persona = personaDAO.buscarPorId(1L);
//        PersonaConsulta personaConsulta = new PersonaConsulta();
//        Convertidor convertidor = new Convertidor();
//        PersonaGeneradaDTO personaGeneradaDTO = convertidor.entityToDTO(persona, new PersonaGeneradaDTO());
//        Calendar fecha1 = Calendar.getInstance();
//        fecha1.add(Calendar.DATE, 1);
//        Calendar fecha2 = Calendar.getInstance();
//        fecha2.add(Calendar.DATE, -1);
        ITramiteDAO tramite = new TramiteDAO();
        List<TramiteEntidad> LISTA = tramite.listaTramite("PlacaEntidad");
        System.out.println("Antes de la lista");
        for(TramiteEntidad tramites: LISTA){
            
            System.out.println(tramites.getTipo());
            
        }
        
        TramiteConsulta tramiteConsulta = new TramiteConsulta();
        List<TramiteDTO> lista = tramiteConsulta.listaTramite("LicenciaEntidad");
        System.out.println("Antes de la lista");
        for(TramiteDTO tramites: lista){
            
            System.out.println(tramites.getTipo());
            
        }

//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//        
//        TramiteEntidad tramiteEntidad = em.find(TramiteEntidad.class, 4L);
//        System.out.println(tramiteEntidad.getTipo());
//        
//        em.getTransaction().commit();
//
//        em.close();
//        emf.close();



//        PersonaConsulta personaConsulta = new PersonaConsulta();
//        PersonaVehiculoAgregar pervehagr = new PersonaVehiculoAgregar();
//        PersonaGeneradaDTO personaGeneradaDTO = personaConsulta.personaPorID(1L);
//        VehiculoNuevoDTO vehiculoNuevoDTO = new VehiculoNuevoDTO("Morado", "Lancer EVO", "Mitsubishi", "2000", "AXDASK2");
//        VehiculoGeneradoDTO vehiculoGeneradoDTO = pervehagr.agregarVehiculoAPersona(personaGeneradaDTO, vehiculoNuevoDTO);
//        System.out.println(vehiculoGeneradoDTO.getNumSerie());
        
//        
//        
//             Calendar fechaNacimineto = Calendar.getInstance();
//        fechaNacimineto.set(2004, 3, 9);
//        PersonaNuevaDTO personaNueva = new PersonaNuevaDTO(fechaNacimineto, "ALSO2983", "6442621169", "Amos Heli", "Olguin", "Quiroz");
//        PersonaConsulta personaConsulta = new PersonaConsulta();
//        PersonaGeneradaDTO personaGeneradaDTO = personaConsulta.agregarPersona(personaNueva);
//        System.out.println(personaGeneradaDTO.getNombre());
        
//        PersonaConsulta personaConsulta = new PersonaConsulta();
//        PersonaGeneradaDTO persona = personaConsulta.personaPorID(1L);
//        VehiculoNuevoDTO vehiculoDTO = new VehiculoNuevoDTO("Acero inoxidable", "DeLorean", "DMC DeLorean", "1982", "ANJYWS6");
//        personaConsulta.agregarVehiculo(vehiculoDTO, persona);
        
        //AGREGAR VEHICULO A PERSONA EXIXSTENTE
//        PersonaEntidad persona = em.find(PersonaEntidad.class, 1L);
//        PersonaConsulta personaConsulta = new PersonaConsulta();
//        PersonaGeneradaDTO personaGeneradaDTO1 = personaConsulta.agregarVehiculo(new VehiculoNuevoDTO("Rojo", "CHARGER SRT", "DODGE", "2012", 122312), persona);
//        System.out.println(personaGeneradaDTO1.getNombre());
        
//        
//       
        
    }
}
