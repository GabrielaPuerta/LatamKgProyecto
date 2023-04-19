package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.dto.ReservaDTO;

import java.util.List;

public interface ReservaService {
    List<ReservaDTO> obtenerReservas();
    ReservaDTO obtenerReserva(Integer id) throws Exception;
    ReservaDTO agregarReserva(ReservaDTO reservaDTO) throws Exception;
}
