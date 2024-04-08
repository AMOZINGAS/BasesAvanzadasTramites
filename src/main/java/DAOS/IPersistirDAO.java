package DAOS;

/**
 * Clase de la Interfaz de la Persistir
 * @author Amós Helí Olguín Quiróz
 */
public interface IPersistirDAO {
    
    /**
     * Metodo que persiste una entidad generica a la base de datos
     * @param <Entidad> tipo generico
     * @param entidad tipo generico
     * @return Una entidad generica que a sido persistida
     */
    public <Entidad> boolean persistirEntidad(Entidad entidad);
    
}
