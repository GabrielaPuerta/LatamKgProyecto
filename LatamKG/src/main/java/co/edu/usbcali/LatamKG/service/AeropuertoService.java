package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.dto.AeropuertoDTO;

import java.sql.SQLException;
import java.util.List;

public interface AeropuertoService {
    AeropuertoDTO agregarAeropuerto(AeropuertoDTO aeropuertoDTO) throws Exception;
    AeropuertoDTO obtenerAeropuerto(Integer id) throws Exception;
    List<AeropuertoDTO> obtenerAeropuertos();
}