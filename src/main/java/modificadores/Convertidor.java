package modificadores;

import java.lang.reflect.Field;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public class Convertidor{

    /**
     * Metodo que convierte los DTOs a Entidades de su mismo tipo
     * @param <Entity>
     * @param <DTO>
     * @param dto
     * @param entity
     * @return la entidad convertide de un dto
     */
    public <Entity, DTO> Entity DTOToEntidad(DTO dto, Entity entity) {
        Class<?> claseDTO = dto.getClass();
        Class<?> claseEntity = entity.getClass();
        Field[] camposDTO = claseDTO.getDeclaredFields();   
        for(Field campoDTO: camposDTO){       
            try {
                String nombreCampoDto = campoDTO.getName();
                campoDTO.setAccessible(true);
                Object valorCampoDto = campoDTO.get(dto);
                try{
                    Field campoEntity = claseEntity.getDeclaredField(nombreCampoDto);
                    campoEntity.setAccessible(true);
                    campoEntity.set(entity, valorCampoDto);
                }catch(NoSuchFieldException nse){
                    
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }   
        return entity;   
    }

    /**
     * Metodo que convierte las entidades en dtos de su mismo tipo
     * @param <Entity>
     * @param <DTO>
     * @param entity
     * @param dto
     * @return el dto convertido de la entidad
     */
    public <Entity, DTO> DTO entityToDTO(Entity entity, DTO dto) {
        Class<?> claseEntity = entity.getClass();
        Class<?> clasesDTO = dto.getClass();
        Field[] camposEntity = claseEntity.getDeclaredFields();   
        for(Field campoEntity: camposEntity){       
            try {
                String nombreCampoEntity = campoEntity.getName();
                campoEntity.setAccessible(true);
                Object valorCampoEntity = campoEntity.get(entity);
                try {
                    Field campoDTO = clasesDTO.getDeclaredField(nombreCampoEntity);
                    campoDTO.setAccessible(true);
                    campoDTO.set(dto, valorCampoEntity);
                } catch (NoSuchFieldException e) {               
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }   
        return dto;
    }
}