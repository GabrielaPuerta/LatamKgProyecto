package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.dto.TrayectoDTO;

import java.util.List;

public interface TrayectoService {
    List<TrayectoDTO> obtenerTrayectos();
    TrayectoDTO obtenerTrayecto(Integer id) throws Exception;
    TrayectoDTO agregarTrayecto(TrayectoDTO trayectoDTO) throws Exception;
}
