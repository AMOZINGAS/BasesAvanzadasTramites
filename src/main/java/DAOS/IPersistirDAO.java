package DAOS;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public interface IPersistirDAO {
    
    /**
     * Metodo que persiste una entidad generica a la base de datos
     * @param <Entidad>
     * @param entidad
     * @return Una entidad generica que a sido persistida
     */
    public <Entidad> boolean persistirEntidad(Entidad entidad);
    
}
