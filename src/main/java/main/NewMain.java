/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import DAOS.IPersonaDAO;
//import Entidades.LicenciaEntidad;
//import Entidades.PersonaEntidad;
//import Entidades.PlacaEntidad;
//import Entidades.TramiteEntidad;
//import Entidades.VehiculoEntidad;
//import Entidades.VehiculoTieneCliente;
import DAOS.LicenciaDAO;
import DAOS.PersonaDAO;
import entidades.LicenciaEntidad;
import entidades.PersonaEntidad;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
//        PersonaEntidad persona = em.find(PersonaEntidad.class, 1L);
//        LicenciaEntidad licencia = new LicenciaEntidad(2, 0, persona);
//        List<LicenciaEntidad> listaLicencias = new ArrayList<>();
//        listaLicencias.add(licencia);
//        persona.setLicencia(listaLicencias);
//        em.persist(persona);
        
        
//        Calendar fechaNacimineto = Calendar.getInstance();
//        fechaNacimineto.set(2004, 3, 9);
//        PersonaEntidad persona = new PersonaEntidad(fechaNacimineto, "QJSL309432", "OUQA040309HSRLRMA5", "6442621169", "Amos Heli", "Olguin", "Quiroz");
//        em.persist(persona);
        
        
        //AGREGAR VEHICULO A PERSONA EXIXSTENTE
//        PersonaEntidad persona = em.find(PersonaEntidad.class, 1L);
//        IPersonaDAO personaDAO = new PersonaDAO();
//        personaDAO.agregarVehiculo(new VehiculoEntidad("Azul", "Eclipse GSX", "Mitsubishi", "1998", 10298212), persona);
        
//PLACA PERSISTIR CON PERSONA Y CARRO        
//        VehiculoEntidad carro = em.find(VehiculoEntidad.class, 1L);
//        PlacaEntidad placa = new PlacaEntidad("AAA333", carro);
//        placa.setCosto(2000);
//        placa.setFechaTramite(Calendar.getInstance());
//        PersonaEntidad persona = em.find(PersonaEntidad.class, 1L);
//        placa.setPersona(persona);
//        List<PlacaEntidad> listaPlacaas = new ArrayList<>();
//        listaPlacaas.add(placa);
//        carro.setPlacas(listaPlacaas);
//        
//        em.persist(persona);
        
        
//VEHICULO PERSISTIR CON PERSONA
//        VehiculoEntidad carro = new VehiculoEntidad("Azul", "Eclipse", "Mitsubishi", "1998", 10);
//        
//        PersonaEntidad persona = em.find(PersonaEntidad.class, 1L);
//        carro.setPersona(persona);
//        List<VehiculoEntidad> listaVehicolos = new ArrayList<>();
//        listaVehicolos.add(carro);
//        persona.setVehiculoCliente(listaVehicolos);
//        carro.setPersona(persona);
//        
//        em.persist(persona);
        
        
//LICENCIA PERISSTIR CON PERSONA        
//        LicenciaEntidad licencia = new LicenciaEntidad(2, 90);
//        licencia.setCosto(200);
//        Calendar fecha = Calendar.getInstance();
//        licencia.setFechaTramite(fecha);
//        fecha.set(2004, 3, 9);
//        PersonaEntidad persona = new PersonaEntidad(fecha, "abc", "6442621169", "AMOS", "OLGUIN", "QUIROZ");
//        licencia.setPersona(persona);
//        persona.setLicencia(licencia);
//        
//        em.persist(persona);
        
        
//PERSISTIR CAMBIOS DE ENTITY Y DTO
//        IConvertidor convertidor = new Convertidor();
//        Calendar fechaNacimiento = Calendar.getInstance();
//        fechaNacimiento.set(2004, 3, 9);
//        PersonaNuevaDTO personaNDTO = new PersonaNuevaDTO(fechaNacimiento, "SJSHKASDUH", "64426211690", "AMOS", "OLGUIN", "QUIROZ");
//        PersonaEntidad personaEntidad = new PersonaEntidad();
//        personaEntidad = convertidor.DTOToEntidad(personaNDTO, personaEntidad);
        
//        Long id = 1L;
//        PersonaEntidad personaEntidad = em.find(PersonaEntidad.class, id);
//        PersonaGeneradaDTO personaGDTO = new PersonaGeneradaDTO();
//        System.out.println(personaEntidad.getNombres());
//        personaGDTO = convertidor.entityToDTO(personaEntidad, personaGDTO);
//        
//        
//        if (personaGDTO == null) {
//            
//            System.out.println("No se pudo agregar");
//            
//        }else{
//            
//            System.out.println(personaGDTO.getApellidoPaterno());
//            System.out.println(personaGDTO.getApellidoMaterno());
//            System.out.println(personaGDTO.getFechaNacimiento());
//            System.out.println(personaGDTO.getIdPersona());
//            System.out.println(personaGDTO.getRfc());
//            System.out.println(personaGDTO.getTelefono());
//            System.out.println(personaGDTO.getNombre());
//            
//        }
        
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        
//        Calendar fechaNacimiento = Calendar.getInstance();
//        fechaNacimiento.set(2004, 3, 9);
//        PersonaEntidad persona = new PersonaEntidad("EUFE45672", fechaNacimiento, "EUFE999", "65550144", "Eugenio", "Fernandez", "Escobar");
//        
//        LicenciaEntidad licencia = new LicenciaEntidad(1, 1, 2000);
//        licencia.setTipoTramite(1);
//        Calendar fecha = Calendar.getInstance();
//        fecha.set(2000, 1, 1);
//        
//        licencia.setFechaTramite(fecha);
//        persona.setLicencia(licencia);
//        licencia.setPersona(persona);
//        VehiculoTieneCliente tiene = new VehiculoTieneCliente();
//        tiene.setCliente(persona);
//        
//        VehiculoEntidad carro = new VehiculoEntidad("azul", "gtr", "nissan", "2000", 23322);
//        tiene.setVehiculo(carro);
//        
//        List<VehiculoTieneCliente> listaTiene = new ArrayList<>();
//        listaTiene.add(tiene);
//        
//        Calendar fecha1 = Calendar.getInstance();
//        fecha1.set(2024, 2, 2);
//        PlacaEntidad placa = new  PlacaEntidad("1",  0, "ABC45" , fecha, fecha);
//        placa.setFechaTramite(fecha);
//        placa.setTipoTramite(2);
//        List<PlacaEntidad> listaPLacas = new ArrayList<>();
//        placa.setVehiculo(carro);
//        listaPLacas.add(placa);
//        
//        persona.setVehiculoCliente(listaTiene);
//        carro.setVehiculoCliente(listaTiene);
//        carro.setPlaca(listaPLacas);
//        List<TramiteEntidad> listatramites = new ArrayList<>();
//        persona.setTramites(listatramites);
//        
//        em.persist(persona);
        
////        
//        LicenciaDAO alguien = new LicenciaDAO();
//        alguien.buscarLicenciasPorFechaNacimiento(fechaNacimiento);
//        System.out.println(alguien.buscarLicenciasPorFechaNacimiento(fechaNacimiento));
        
        
    }
    
}
