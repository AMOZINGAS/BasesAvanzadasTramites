/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package banco.itson.edu.negocioagenciatransito;

import DAOS.IPersonaDAO;
import DAOS.PersonaDAO;
import DTO.PersonaGeneradaDTO;
import DTO.PersonaNuevaDTO;
import DTO.VehiculoGeneradoDTO;
import DTO.VehiculoNuevoDTO;
import entidades.PersonaEntidad;
//import Entidades.PersonaEntidad;
//import Entidades.VehiculoEntidad;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import negocio.PersonaConsulta;
import negocio.PersonaVehiculoAgregar;

/**
 *
 * @author elimo
 */
public class NegocioAgenciaTransito {

    public static void main(String[] args) {
        
        PersonaConsulta personaConsulta = new PersonaConsulta();
        PersonaVehiculoAgregar pervehagr = new PersonaVehiculoAgregar();
        PersonaGeneradaDTO personaGeneradaDTO = personaConsulta.personaPorID(1L);
        VehiculoNuevoDTO vehiculoNuevoDTO = new VehiculoNuevoDTO("Morado", "Lancer EVO", "Mitsubishi", "2000", "AXDASK2");
        VehiculoGeneradoDTO vehiculoGeneradoDTO = pervehagr.agregarVehiculoAPersona(personaGeneradaDTO, vehiculoNuevoDTO);
        System.out.println(vehiculoGeneradoDTO.getNumSerie());
        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
//        EntityManager em = emf.createEntityManager();
////        
//        em.getTransaction().begin();
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
//        em.getTransaction().commit();
//        
//        em.close();
//        emf.close();
        
    }
}
