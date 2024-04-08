package negocio;

import DAOS.IPersonaDAO;
import DAOS.ITramiteDAO;
import DAOS.PersonaDAO;
import DAOS.TramiteDAO;
import DTO.LicenciaGeneradaDTO;
import DTO.PersonaGeneradaDTO;
import DTO.TramiteDTO;
import POJO.ReportePDF;
import entidades.PersonaEntidad;
import entidades.TramiteEntidad;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import modificadores.Convertidor;

/**
 *
 * @author Amós Helí Olguín Quiróz
 */
public class TramiteConsulta {
    
    private final ITramiteDAO tramiteDAO;
    
    /**
     * Constructor que inicializa el tramite dao
     */
    public TramiteConsulta(){
        tramiteDAO = new TramiteDAO();
    }
    
    /**
     * metodo que genera una lita de todos los tramites existentes
     * @return 
     */
    public List<TramiteDTO> listaCompletaTramite(){
        List<TramiteDTO> listaCompletaTramiteDTO = new ArrayList<>();
        for(TramiteEntidad tramite: tramiteDAO.listaTramites()){
            TramiteDTO tramiteDTO = new TramiteDTO();
            tramiteDTO.setIdTramite(tramite.getId());
            if(tramite.getTipo()==null){
                tramiteDTO.setTipo(tramiteDAO.buscarTipoTramite(tramite.getId()));
            }else{
                tramiteDTO.setTipo(tramite.getTipo());
            }
            tramiteDTO.setCosto(tramite.getCosto());
            tramiteDTO.setFechaTramite(tramite.getFechaTramite());
            listaCompletaTramiteDTO.add(tramiteDTO);
        }
        return listaCompletaTramiteDTO;
    }
    
    /**
     * metodo que busca un tramite por un id dado como parametro
     * @param id
     * @return 
     */
    public TramiteDTO buscarTramitePorId(Long id){
        TramiteEntidad tramiteEntidad = tramiteDAO.buscaTramitePorId(id);
        Convertidor convertidor= new Convertidor();
        return convertidor.entityToDTO(tramiteEntidad, new TramiteDTO());
    }
    
    /*+
    metodo que genera una lista de reporte generados por una lista de tramites
    */
    public List<ReportePDF> listaCompletaReporte(){
        List<TramiteDTO> listaCompletaDTO = listaCompletaTramite();
        List<ReportePDF> listaCompletaReporte = new ArrayList<>();
        for(TramiteDTO tramiteDTO: listaCompletaDTO){
            ReportePDF reporte = new ReportePDF();
            reporte.setCosto(tramiteDTO.getCosto());
            reporte.setFechaTramite(tramiteDTO.getFechaTramite());
            TramiteEntidad tramiteEntidad = tramiteDAO.buscaTramitePorId(tramiteDTO.getIdTramite());
            reporte.setNombres(tramiteEntidad.getPersona().getNombres());
            if(tramiteDTO.getTipo().equalsIgnoreCase("LicenciaEntidad")){                
                reporte.setTipo("Expedicion de Licencia");                
            }
            if(tramiteDTO.getTipo().equalsIgnoreCase("PlacaEntidad")){                
                reporte.setTipo("Expedicion de Placa");                
            }
            listaCompletaReporte.add(reporte);            
        }
        return listaCompletaReporte;        
    }

    /**
     * metodo que generea una lista de los reportes encontrados coincidentes con
     * el nombre dado como parametro
     * @param listaReportes
     * @param nombre
     * @return 
     */
    public List<ReportePDF> buscarTramitesPorNombre(List<ReportePDF> listaReportes, String nombre){
        ITramiteDAO tramiteDAO = new TramiteDAO();
        List<TramiteEntidad> listaTramiteEntidad = tramiteDAO.listaTramiterNombre(nombre);
        Set<ReportePDF> setTemp = new HashSet<>();
        for (TramiteEntidad tramite : listaTramiteEntidad) {
            ReportePDF reporte = new ReportePDF();
            reporte.setCosto(tramite.getCosto());
            reporte.setFechaTramite(tramite.getFechaTramite());
            TramiteEntidad tramiteEntidad = tramiteDAO.buscaTramitePorId(tramite.getId());
            reporte.setNombres(tramiteEntidad.getPersona().getNombres());
            if(tramite.getTipo()==null){
                    tramite.setTipo(tramiteDAO.buscarTipoTramite(tramite.getId()));
                }else{
                    tramite.setTipo(tramite.getTipo());
                }
            String tipo = tramite.getTipo().equalsIgnoreCase("LicenciaEntidad") ? "Expedicion de Licencia" :
                         tramite.getTipo().equalsIgnoreCase("PlacaEntidad") ? "Expedicion de Placa" :
                         tramite.getTipo();
            reporte.setTipo(tipo);
            setTemp.add(reporte);
        }
        return new ArrayList<>(setTemp);
    }
    
    /**
     * metodo que generea una lista de reportes que se encuentren como 
     * coincidentes entre las fechas dadas como parametro
     * @param listaReportes
     * @param fechaDesde
     * @param fechaHasta
     * @return 
     */
    public List<ReportePDF> listaPorPeriodo(List<ReportePDF> listaReportes, Calendar fechaDesde, Calendar fechaHasta){
        ITramiteDAO tramiteDAO = new TramiteDAO();
        List<TramiteEntidad> listaTramiteEntidad = tramiteDAO.listaTramiterFecha(fechaDesde, fechaHasta);
        List<ReportePDF> listaReportePDF = new ArrayList<>();
        for (TramiteEntidad tramite : listaTramiteEntidad) {
            ReportePDF reporte = new ReportePDF();
            reporte.setCosto(tramite.getCosto());
            reporte.setFechaTramite(tramite.getFechaTramite());
            reporte.setNombres(tramite.getPersona().getNombres());
            if(tramite.getTipo()==null){
                    tramite.setTipo(tramiteDAO.buscarTipoTramite(tramite.getId()));
                }else{
                    tramite.setTipo(tramite.getTipo());
                }
            switch (tramite.getTipo()) {
                case "LicenciaEntidad":
                    reporte.setTipo("Expedicion de Licencia");
                    break;
                case "PlacaEntidad":
                    reporte.setTipo("Expedicion de Placa");
                    break;
                default:
                    reporte.setTipo(tramite.getTipo());
                    break;
            }
            listaReportePDF.add(reporte);
        }
        return obtenerElementosComunes(listaReportes, listaReportePDF);
    }
    
    /**
     * metodo que busca los objetod coincidentes entre las dos listas dadas
     * como parametro
     * @param lista1
     * @param lista2
     * @return 
     */
    public List<ReportePDF> obtenerElementosComunes(List<ReportePDF> lista1, List<ReportePDF> lista2) {
        List<ReportePDF> listaFiltrada = new ArrayList<>();
        Set<ReportePDF> setTemp = new HashSet<>(lista1);
        for (ReportePDF reporte : lista2) {
            if (setTemp.contains(reporte)) {
                listaFiltrada.add(reporte);
            }
        }
        return listaFiltrada;
    }
    
    /**
     * metodo que generea una lista de reportes que coincidan con el tipo de 
     * tramite dado como parametro
     * @param listaReportes
     * @param tipo
     * @return 
     */
    public List<ReportePDF> listaPorTipoTramite(List<ReportePDF> listaReportes, String tipo){
        ITramiteDAO tramiteDAO = new TramiteDAO();
        List<TramiteEntidad> listaTramiteEntidad = tramiteDAO.listaTramite(tipo);
        List<ReportePDF> listaReportePDF = new ArrayList<>();
        Set<ReportePDF> setTemp = new HashSet<>();
        for (TramiteEntidad tramite : listaTramiteEntidad) {
            ReportePDF reporte = new ReportePDF();
            reporte.setCosto(tramite.getCosto());
            reporte.setFechaTramite(tramite.getFechaTramite());
            reporte.setNombres(tramite.getPersona().getNombres());
            if(tramite.getTipo()==null){
                tramite.setTipo(tramiteDAO.buscarTipoTramite(tramite.getId()));
            }else{
                tramite.setTipo(tramite.getTipo());
            }
            switch (tramite.getTipo()) {
                case "LicenciaEntidad":
                    reporte.setTipo("Expedicion de Licencia");
                    break;
                case "PlacaEntidad":
                    reporte.setTipo("Expedicion de Placa");
                    break;
                default:
                    reporte.setTipo(tramite.getTipo());
                    break;
            }
            listaReportePDF.add(reporte);
        }
        return obtenerElementosComunes(listaReportes, listaReportePDF);
    }
    
    /**
     * metodo que generea una lista de tramites que coincidan con la persona 
     * dada como parametro y que se encuentre dentro de las fechas dadas como
     * parametro
     * @param personaGeneradaDTO
     * @param fechaHsta
     * @param fechaDesde
     * @return 
     */
    public List<TramiteDTO> listaTramitesPersona(PersonaGeneradaDTO personaGeneradaDTO, Calendar fechaHsta, Calendar fechaDesde){
        IPersonaDAO personaDAO = new PersonaDAO();
        PersonaEntidad persona = personaDAO.buscarPorId(personaGeneradaDTO.getIdPersona());
        List<TramiteEntidad> listaTramites = tramiteDAO.listaTramiterPersonaFecha(persona, fechaHsta, fechaDesde);
        List<TramiteDTO> listaDTO = new ArrayList<>();
        for(int i = 0; i < listaTramites.size(); i ++){
            TramiteEntidad tramiteEntidad = listaTramites.get(i);
            TramiteDTO tramiteDTO = new TramiteDTO();
            tramiteDTO.setIdTramite(tramiteEntidad.getId());
            tramiteDTO.setCosto(tramiteEntidad.getCosto());
            tramiteDTO.setEstado(tramiteEntidad.getEstado());
            tramiteDTO.setFechaTramite(tramiteEntidad.getFechaTramite());
            if(tramiteEntidad.getTipo()==null){
                tramiteDTO.setTipo(tramiteDAO.buscarTipoTramite(tramiteEntidad.getId()));
            }else{
                tramiteDTO.setTipo(tramiteEntidad.getTipo());
            }
            listaDTO.add(tramiteDTO);
        }
        return listaDTO;
    }
    
    /**
     * metodo que verifica la vigencia de la licencia 
     * @param tramiteDTO
     * @return 
     */
    public int vigenciaLicencia(TramiteDTO tramiteDTO){
        LicenciaConsulta licenciaConsulta = new LicenciaConsulta();
        LicenciaGeneradaDTO licenciaGeneradaDTO = licenciaConsulta.buscarLicenciaId(tramiteDTO.getIdTramite());
        if(licenciaGeneradaDTO==null){
            
            JOptionPane.showMessageDialog(null, "No se encontró con un tramite", "ADVERTENCIA!!", JOptionPane.INFORMATION_MESSAGE);
            return 0;
        }else{
            
            LicenciaGeneradaDTO licenciaGeneradaDTO1 = new LicenciaGeneradaDTO(licenciaGeneradaDTO.getId(), licenciaGeneradaDTO.getVigencia(), licenciaGeneradaDTO.getFolio(), licenciaGeneradaDTO.getCosto(), licenciaGeneradaDTO.getFechaTramite(), licenciaGeneradaDTO.getEstado());
        int vigencia = licenciaGeneradaDTO1.getVigencia();
        return vigencia;
            
        }
        
    }
    
    /**
     * metodo que generea una lista de tramites que coincidan con la persona,
     * el tipo y las fechas que se encuentren dentro de lo establecido
     * @param personaGeneradaDTO
     * @param tipo
     * @param fechaHsta
     * @param fechaDesde
     * @return 
     */
    public List<TramiteDTO> listaTramitePersonaTipo(PersonaGeneradaDTO personaGeneradaDTO, String tipo, Calendar fechaHsta, Calendar fechaDesde){
        IPersonaDAO personaDAO = new PersonaDAO();
        PersonaEntidad persona = personaDAO.buscarPorId(personaGeneradaDTO.getIdPersona());
        List<TramiteEntidad> listaTramites = tramiteDAO.listaTramitePersonaTipoFecha(persona, tipo, fechaHsta, fechaDesde);
        List<TramiteDTO> listaDTO = new ArrayList<>();
        for(int i = 0; i < listaTramites.size(); i ++){
            TramiteEntidad tramiteEntidad = listaTramites.get(i);
            TramiteDTO tramiteDTO = new TramiteDTO();
            tramiteDTO.setIdTramite(tramiteEntidad.getId());
            tramiteDTO.setCosto(tramiteEntidad.getCosto());
            tramiteDTO.setEstado(tramiteEntidad.getEstado());
            tramiteDTO.setFechaTramite(tramiteEntidad.getFechaTramite());
            if(tramiteEntidad.getTipo()==null){
                tramiteDTO.setTipo(tramiteDAO.buscarTipoTramite(tramiteEntidad.getId()));
            }else{
                tramiteDTO.setTipo(tramiteEntidad.getTipo());
            }
            listaDTO.add(tramiteDTO);
        }
        return listaDTO;
    }
    
    /**
     * metodo que generea una lista de tramites que coincidan con el tipo
     * de tramite dado como parametro
     * @param tipo
     * @return 
     */
    public List<TramiteDTO> listaTramite(String tipo){
        List<TramiteEntidad> listaTramites = tramiteDAO.listaTramite(tipo);
        List<TramiteDTO> listaDTO = new ArrayList<>();
        for(int i = 0; i < listaTramites.size(); i ++){
            TramiteEntidad tramiteEntidad = listaTramites.get(i);
            TramiteDTO tramiteDTO = new TramiteDTO();
            tramiteDTO.setIdTramite(tramiteEntidad.getId());
            tramiteDTO.setCosto(tramiteEntidad.getCosto());
            tramiteDTO.setEstado(tramiteEntidad.getEstado());
            tramiteDTO.setFechaTramite(tramiteEntidad.getFechaTramite());
            if(tramiteEntidad.getTipo()==null){
                tramiteDTO.setTipo(tramiteDAO.buscarTipoTramite(tramiteEntidad.getId()));
            }else{
                tramiteDTO.setTipo(tramiteEntidad.getTipo());
            }
            listaDTO.add(tramiteDTO);
        }
        return listaDTO;
    }
}