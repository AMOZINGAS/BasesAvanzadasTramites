/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import Interfaces.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author PC
 */
public class ConexionBD implements IConexionBD{
    
    EntityManagerFactory managerFactory;
    EntityManager entityManager;
    String nombrePersistencia = "agenciatransito";
    
    public ConexionBD(){}
    
    @Override
    public EntityManager crearConexion(){
        
        managerFactory = Persistence.createEntityManagerFactory(nombrePersistencia);
        
        entityManager = managerFactory.createEntityManager();
        
        return entityManager;
        
    }
    
}
