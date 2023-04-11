package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.dto.TipoAsientoDTO;

import java.util.List;

public interface TipoAsientoService {
    List<TipoAsientoDTO> obtenerTipoAsientos();
    TipoAsientoDTO obtenerTipoAsiento(Integer id) throws Exception;
    TipoAsientoDTO agregarTipoAsiento(TipoAsientoDTO tipoAsientoDTO) throws Exception;
}
