package co.edu.usbcali.LatamKG.service.implementation;

import co.edu.usbcali.LatamKG.domain.Asiento;
import co.edu.usbcali.LatamKG.domain.Reserva;
import co.edu.usbcali.LatamKG.domain.Vuelo;
import co.edu.usbcali.LatamKG.dto.ReservaDTO;
import co.edu.usbcali.LatamKG.mapper.ReservaMapper;
import co.edu.usbcali.LatamKG.repository.AsientoRepository;
import co.edu.usbcali.LatamKG.repository.ReservaRepository;
import co.edu.usbcali.LatamKG.repository.TipoAsientoRepository;
import co.edu.usbcali.LatamKG.repository.VueloRepository;
import co.edu.usbcali.LatamKG.service.ReservaService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository reservaRepository;
    private final VueloRepository vueloRepository;
    private final ModelMapper modelMapper;
    public ReservaServiceImpl(ReservaRepository reservaRepository, VueloRepository vueloRepository, ModelMapper modelMapper) {
        this.reservaRepository = reservaRepository;
        this.vueloRepository = vueloRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<ReservaDTO> obtenerReservas() {
        return ReservaMapper.domainToDTOList(reservaRepository.findAll());
    }
    @Override
    public ReservaDTO obtenerReserva(Integer id) throws Exception {
        if (reservaRepository.findById(id).isEmpty()) {
            throw new Exception("El id " + id + " no corresponde a ninguna reserva!");
        }
        return ReservaMapper.domainToDTO(reservaRepository.findById(id).get());
    }
    @Override
    public ReservaDTO agregarReserva(ReservaDTO reservaDTO) throws Exception {
        if (reservaDTO == null) {
            throw new Exception("La reserva es invalida!");
        }
        if (reservaDTO.getPrecioTotal() < 0) {
            throw new Exception("El precio de la reserva no puede ser negativo!");
        }
        if (reservaDTO.getEstadoPago() == null || reservaDTO.getEstadoPago().isBlank() || reservaDTO.getEstadoPago().trim().isEmpty()) {
            throw new Exception("El estado de pago de la reserva es invalido!");
        }
        if (reservaDTO.getEstado() == null || reservaDTO.getEstado().isBlank() || reservaDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado de la reserva es invalido!");
        }
        Reserva reserva = ReservaMapper.dtoToDomain(reservaDTO);
        Vuelo vuelo = vueloRepository.findById(reservaDTO.getIdVuelo()).get();
        reserva.setPrecioTotal(vuelo.getPrecio());
        reserva.setVuelo(vuelo);

        Reserva saved = reservaRepository.save(reserva);


        return ReservaMapper.domainToDTO(saved);
    }
}
