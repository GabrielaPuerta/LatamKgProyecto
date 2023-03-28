package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.dto.VueloDTO;

import java.util.List;

public interface VueloService {
    VueloDTO guardarVuelo(VueloDTO vuelDTO) throws Exception;
    VueloDTO obtenerVuelo(Integer id) throws Exception;
    List<VueloDTO> obtenerVuelos();

}
