package co.edu.usbcali.LatamKG.service.implementation;

import co.edu.usbcali.LatamKG.domain.Asiento;
import co.edu.usbcali.LatamKG.domain.Reserva;
import co.edu.usbcali.LatamKG.domain.TipoAsiento;
import co.edu.usbcali.LatamKG.dto.AsientoDTO;
import co.edu.usbcali.LatamKG.mapper.AsientoMapper;
import co.edu.usbcali.LatamKG.repository.AsientoRepository;

import co.edu.usbcali.LatamKG.repository.ReservaRepository;
import co.edu.usbcali.LatamKG.repository.TipoAsientoRepository;
import co.edu.usbcali.LatamKG.service.AsientoService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AsientoServiceImpl implements AsientoService {
    private final AsientoRepository asientoRepository;
    private final TipoAsientoRepository tipoAsientoRepository;
    private final ReservaRepository reservaRepository;
    private final ModelMapper modelMapper;

    public AsientoServiceImpl(AsientoRepository asientoRepository, TipoAsientoRepository tipoAsientoRepository, ReservaRepository reservaRepository, ModelMapper modelMapper) {
        this.asientoRepository = asientoRepository;
        this.tipoAsientoRepository = tipoAsientoRepository;
        this.reservaRepository = reservaRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<AsientoDTO> obtenerAsientos() {
        return AsientoMapper.domainToDTOList(asientoRepository.findAll());
    }
    @Override
    public AsientoDTO obtenerAsiento(Integer id) throws Exception {
        if (asientoRepository.findById(id).isEmpty()) {
            throw new Exception("El id " + id + " no corresponde a ningun asiento!");
        }
        return AsientoMapper.domainToDTO(asientoRepository.findById(id).get());
    }
    @Override
    public AsientoDTO agregarAsiento(AsientoDTO asientoDTO) throws Exception {
        if (asientoDTO == null) {
            throw new Exception("El asiento es nulo!");
        }
        if (asientoDTO.getUbicacion() == null || asientoDTO.getUbicacion().isBlank() || asientoDTO.getUbicacion().trim().isEmpty()) {
            throw new Exception("La ubicación del asiento no es valido!");
        }
        if (asientoDTO.getPrecio() < 0) {
            throw new Exception("El precio del asiento no debe ser negativo!");
        }
        if (asientoDTO.getEstado() == null || asientoDTO.getEstado().isBlank() || asientoDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado del asiento no es valido!");
        }
        if(asientoRepository.findById(asientoDTO.getIdAsiento()).isPresent()){
            throw new Exception("id de asiento ya existente!");
        }
        Asiento asiento = AsientoMapper.dtoToDomain(asientoDTO);
        TipoAsiento tipoAsiento = tipoAsientoRepository.findById(asientoDTO.getIdTipoAsiento()).get();
        Reserva reserva = reservaRepository.findById(asientoDTO.getIdReserva()).get();
        asiento.setTipoAsiento(tipoAsiento);
        asiento.setReserva(reserva);
        return AsientoMapper.domainToDTO(asientoRepository.save(asiento));
    }
}
