package excepciones;

/**
 * Clase para la persistencia
 * @author Amós Helí Olguín Quiróz
 */
public class PersistenciaException extends RuntimeException{

    /**
     * Metodo que regresa un mensaje de una persistencia
     * @param message tipo string
     */
    public PersistenciaException(String message) {
        super(message);
    }

    /**
     * Metodo que regresa un mensaje y la causa de una persistencia 
     * @param message tipo string
     * @param cause tipo throwable
     */
    public PersistenciaException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Metodo que regresa la throwable de la causa
     * @param cause tipo throwable
     */
    public PersistenciaException(Throwable cause) {
        super(cause);
    }
    
    /**
     * Metodo que regresa un mensaje, el throwable de la causa y mas
     * @param message tipo string
     * @param cause tipo throwabler
     * @param enableSuppression tipo boolean
     * @param writableStackTrace tipo boolean
     */
    public PersistenciaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    /**
     * Constructor por defecto
     */
    public PersistenciaException() {
        super();
    }

}