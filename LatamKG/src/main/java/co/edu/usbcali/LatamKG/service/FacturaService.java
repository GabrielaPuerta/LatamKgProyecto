package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.dto.FacturaDTO;

import java.util.List;

public interface FacturaService {
    List<FacturaDTO> obtenerFacturas();
    FacturaDTO obtenerFactura(Integer id) throws Exception;
    FacturaDTO agregarFactura(FacturaDTO facturaDTO) throws Exception;
}