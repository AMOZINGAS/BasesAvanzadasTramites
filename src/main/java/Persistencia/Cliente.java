/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Persistencia;

import DTO.PersonaGeneradaDTO;
import DTO.PersonaNuevaDTO;
import Entidades.PersonaEntidad;
import Interfaces.ICliente;
import Interfaces.IConexionBD;
import java.sql.SQLException;
import javax.persistence.EntityManager;

/**
 *
 * @author PC
 */
public class Cliente implements ICliente{

    private final IConexionBD conexionBD;
    private final EntityManager entityManagaer;
    
    public Cliente() throws SQLException{
    
        conexionBD = new ConexionBD();
        entityManagaer = conexionBD.crearConexion();
        
    }
    
    @Override
    public PersonaNuevaDTO buscarPorId(Long id) {
    
        return null;
        
    }

    @Override
    public PersonaEntidad agregarCliente(PersonaEntidad clienteEntidad) {
    
        entityManagaer.getTransaction().begin();
        
        entityManagaer.persist(clienteEntidad);
        
        entityManagaer.getTransaction().commit();
        
        return clienteEntidad;
        
    }
    
    
    
}
