package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.dto.AvionDTO;

import java.util.List;

public interface AvionService {
    List<AvionDTO> obtenerAviones();
    AvionDTO obtenerAvion(Integer id) throws Exception;
    AvionDTO agregarAvion(AvionDTO avionDTO) throws Exception;
}