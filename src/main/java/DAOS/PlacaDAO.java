package DAOS;

import entidades.PlacaEntidad;
import entidades.VehiculoEntidad;

public class PlacaDAO implements IPlacaDAO {

    @Override
    public PlacaEntidad agregarVehiculo(VehiculoEntidad vehiculoEntidad, PlacaEntidad placaEntidad) {
    
        placaEntidad.setVehiculo(vehiculoEntidad);
        return placaEntidad;
    
    }
    
    

}
