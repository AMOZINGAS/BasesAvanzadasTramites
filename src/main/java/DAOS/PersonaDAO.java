package DAOS;

import entidades.LicenciaEntidad;
import entidades.PersonaEntidad;
import entidades.VehiculoEntidad;
import excepciones.PersistenciaException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 * Clase de la persona dao
 * @author Amós Helí Olguín Quiróz
 */
public class PersonaDAO implements IPersonaDAO {

    private final int clave = 7;
    private final IConexionBD conexionBD = new ConexionBD();
    private EntityManager entityManager;

    /**
     * Constructor que inicializa la conexion
     */
    public PersonaDAO() {
        try {
            entityManager = conexionBD.crearConexion();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Metodo que agrega a una persona a la base de datos
     * @param personaEntidad tipo persona entidad
     * @return la persona agregada
     */
    @Override
    public PersonaEntidad agregarPersona(PersonaEntidad personaEntidad) throws PersistenciaException{
        try {
            IPersistirDAO persistirDAO = new PersistirDAO();
            personaEntidad.setNombres(encriptar(personaEntidad.getNombres(), clave));
            System.out.println("Metodo antes agregar persona\nNombre: " + personaEntidad.getNombres());
            persistirDAO.persistirEntidad(personaEntidad);
            personaEntidad.setNombres(desencriptar(personaEntidad.getNombres(), clave));
            System.out.println("Metodo despues agregar persona\nNombre: " + personaEntidad.getNombres());
            return personaEntidad;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     * Metodo que busca a una persona por el id enviado como parametro
     * @param id tipo long
     * @return la persona encontrada, null en caso contrario
     */
    @Override
    public PersonaEntidad buscarPorId(Long id) {
            try{
                CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
                CriteriaQuery<PersonaEntidad> consulta = criteria.createQuery(PersonaEntidad.class);
                Root<PersonaEntidad> root = consulta.from(PersonaEntidad.class);
                consulta = consulta.select(root).where(criteria.equal(root.get("idPersona"), id));
                TypedQuery<PersonaEntidad> query = entityManager.createQuery(consulta);
                PersonaEntidad persona = query.getSingleResult();
                System.out.println("Metodo buscarPorID\nNombre: " + persona.getNombres());
                return persona;
            }catch(NoResultException nre){
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, nre);
                return null;
            }
    }

    /**
     * Metodo que genera una lista de personas que coincidan con el nombre dado
     * como parametro
     * @param nombre tipo string
     * @return lista de personas encontradas
     */
    @Override
    public List<PersonaEntidad> buscarPorNombre(String nombre) {
        nombre = encriptar(nombre, clave);
        System.out.println("Metodo antes buscarPorNombre\nNombre: " + nombre);
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonaEntidad> consulta = criteria.createQuery(PersonaEntidad.class);
        Root<PersonaEntidad> root = consulta.from(PersonaEntidad.class);
        consulta = consulta.select(root).where(criteria.like(root.get("nombres"), "%" + nombre + "%"));
        TypedQuery<PersonaEntidad> query = entityManager.createQuery(consulta);
        List<PersonaEntidad> listaPersonasPorNombre = query.getResultList();
        for(PersonaEntidad persona: listaPersonasPorNombre){
            persona.setNombres(desencriptar(persona.getNombres(), clave));
            System.out.println("Metodo despues buscarPorNombre\nNombre: " + persona.getNombres());
        }
        return listaPersonasPorNombre;
    }
    
    /**
     * Metodo que genera una lista de persona por nombre y una curp dados 
     * como parametro
     * @param nombre tipo string
     * @param curp tipo string
     * @return una lista de personas encontradas
     */
    @Override
    public List<PersonaEntidad> buscarPorNombreCurp(String nombre, String curp) {
        System.out.println("Metodo antes buscarPorCurp\nNombre: " + nombre);
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonaEntidad> consulta = criteria.createQuery(PersonaEntidad.class);
        Root<PersonaEntidad> root = consulta.from(PersonaEntidad.class);
        consulta = consulta.select(root).where(criteria.like(root.get("nombres"), "%" + nombre + "%"));
        consulta = consulta.select(root).where(criteria.like(root.get("curp"), "%" + curp + "%"));
        TypedQuery<PersonaEntidad> query = entityManager.createQuery(consulta);
        List<PersonaEntidad> listaPersonasPorNombre = query.getResultList();
        for(PersonaEntidad persona: listaPersonasPorNombre){
            System.out.println("Metodo despues buscarPorNombreCurp\nNombre: " + persona.getNombres());
        }
        return listaPersonasPorNombre;
    }
    
    /**
     * Metodo que genera la lista completa de personas que están registradas
     * @return lista de personas encontradas
     */
    @Override
    public List<PersonaEntidad> listaPersonas() {
        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<PersonaEntidad> consulta = criteria.createQuery(PersonaEntidad.class);
        Root<PersonaEntidad> root = consulta.from(PersonaEntidad.class);
        TypedQuery<PersonaEntidad> query = entityManager.createQuery(consulta);
        List<PersonaEntidad> listaPersonas = query.getResultList();
        for(PersonaEntidad persona: listaPersonas){
            persona.setNombres(desencriptar(persona.getNombres(), clave));
            System.out.println("Metodo listaPersonas\nNombre: " + persona.getNombres());
        }
        return listaPersonas;
    }

    /**
     * Metodo que actualiza a la persona enviada como parametro
     * @param personaEntidad tipo persona entidad
     * @return la persona que se actualizó
     */
    @Override
    public PersonaEntidad actualizarPersona(PersonaEntidad personaEntidad){
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            System.out.println("Metodo antes actualizarPersona\nNombre: " + personaEntidad.getNombres());
            entityManager.merge(personaEntidad);
             System.out.println("Metodo despues actualizarPersona\nNombre: " + personaEntidad.getNombres());
            transaction.commit();
            return personaEntidad;
        } catch (PersistenciaException ex) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            return null;
        }
    }
    
    /**
     * Metodo que agrega una referencia de un vehiculo a una personas enviada
     * como parametro
     * @param vehiculoEntidad tipo vehiculo entidad
     * @param personEntidad tipo persona entidad
     * @return la persona con la referencia del vehiculo
     */
    @Override
    public PersonaEntidad agregarVehiculo(VehiculoEntidad vehiculoEntidad, PersonaEntidad personEntidad) {
        System.out.println("Metodo antes agregarVehiculo\nNombre: " + personEntidad.getNombres());
        List<VehiculoEntidad> listaVehiculos = personEntidad.getVehiculo();
        listaVehiculos.add(vehiculoEntidad);
        personEntidad.setVehiculo(listaVehiculos);
        System.out.println("Metodo despues agregarVehiculo\nNombre: " + personEntidad.getNombres());
        return personEntidad;
    }

    /**
     * Metodo que busca una persona por una curp dada como parametro
     * @param curp tipo string
     * @return la persona encontrada, null en caso contrario
     */
    @Override
    public PersonaEntidad buscarPorCurp(String curp) {
        try{
                CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
                CriteriaQuery<PersonaEntidad> consulta = criteria.createQuery(PersonaEntidad.class);
                Root<PersonaEntidad> root = consulta.from(PersonaEntidad.class);
                consulta = consulta.select(root).where(criteria.equal(root.get("curp"), curp));
                TypedQuery<PersonaEntidad> query = entityManager.createQuery(consulta);
                PersonaEntidad personaEntidad = query.getSingleResult();
                System.out.println("Metodo buscarPorCurp\nNombre: " + personaEntidad.getNombres());
                return  personaEntidad;
            }catch(NoResultException nre){
                Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, nre);
                return null;
            }
    }
    
    /**
     * Metodo que agrega una referencia de una licencia a una persona dada
     * como parametro
     * @param licenciaEntidad tipo licencia entidad
     * @param personEntidad tipo persona entidad
     * @return la persona con la referencia de la licencia
     */
    @Override
    public PersonaEntidad agregarLicencia(LicenciaEntidad licenciaEntidad, PersonaEntidad personEntidad) {
        System.out.println("Metodo antes agregarLicencia\nNombre: " + personEntidad.getNombres());
        List<LicenciaEntidad> listaLicencias = personEntidad.getLicencia();
        for(int i = 0; i < listaLicencias.size(); i ++){
            listaLicencias.get(i).setEstado(0);
        }
        listaLicencias.add(licenciaEntidad);
        personEntidad.setLicencia(listaLicencias);
        System.out.println("Metodo despues agregarLicencia\nNombre: " + personEntidad.getNombres());
        return personEntidad;
        
    }    
    
    /**
     * metodo que encripta un texto con una clave
     * @param texto tipo string
     * @param clave tipo int
     * @return el nombre encriptado
     */
    @Override
    public String encriptar(String texto, int clave) {
        StringBuilder resultado = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char caracter = texto.charAt(i);
            if (Character.isLetter(caracter)) {
                char base = Character.isLowerCase(caracter) ? 'a' : 'A';
                char encriptado = (char) (((caracter - base + clave) % 26) + base);
                resultado.append(encriptado);
            } else {
                resultado.append(caracter);
            }
        }
        return resultado.toString();
    }
    
    /**
     * Metodo que desencripta los nombre
     * @param textoEncriptado tipo string
     * @param clave tipo int
     * @return el texto desencriptado
     */
    @Override
    public String desencriptar(String textoEncriptado, int clave) {
        return encriptar(textoEncriptado, 26 - clave);
    }
    
    /**
     * Metodo que regresa la clave de encriptacion
     * @return clave
     */
    @Override
    public int getClave(){
        return clave;
    }
    
}