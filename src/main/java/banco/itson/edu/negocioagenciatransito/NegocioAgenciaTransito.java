/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package banco.itson.edu.negocioagenciatransito;

import DAOS.IPersonaDAO;
import DAOS.PersonaDAO;
import DTO.PersonaGeneradaDTO;
import DTO.PersonaNuevaDTO;
import DTO.VehiculoDTO;
import entidades.PersonaEntidad;
//import Entidades.PersonaEntidad;
//import Entidades.VehiculoEntidad;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import negocio.PersonaConsulta;

/**
 *
 * @author elimo
 */
public class NegocioAgenciaTransito {

    public static void main(String[] args) {
        
        
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
        
        PersonaConsulta personaConsulta = new PersonaConsulta();
        PersonaGeneradaDTO persona = personaConsulta.personaPorID(1L);
        VehiculoDTO vehiculoDTO = new VehiculoDTO("Acero inoxidable", "DeLorean", "DMC DeLorean", "1982", "ANJYWS6");
        personaConsulta.agregarVehiculo(vehiculoDTO, persona);
        
        //AGREGAR VEHICULO A PERSONA EXIXSTENTE
//        PersonaEntidad persona = em.find(PersonaEntidad.class, 1L);
//        PersonaConsulta personaConsulta = new PersonaConsulta();
//        PersonaGeneradaDTO personaGeneradaDTO1 = personaConsulta.agregarVehiculo(new VehiculoDTO("Rojo", "CHARGER SRT", "DODGE", "2012", 122312), persona);
//        System.out.println(personaGeneradaDTO1.getNombre());
        
//        
//        em.getTransaction().commit();
//        
//        em.close();
//        emf.close();
        
    }
}
