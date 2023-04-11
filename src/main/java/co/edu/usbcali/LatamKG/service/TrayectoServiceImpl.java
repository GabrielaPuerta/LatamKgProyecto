package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.domain.Aeropuerto;
import co.edu.usbcali.LatamKG.domain.Trayecto;
import co.edu.usbcali.LatamKG.domain.Vuelo;
import co.edu.usbcali.LatamKG.dto.TrayectoDTO;
import co.edu.usbcali.LatamKG.mapper.TrayectoMapper;
import co.edu.usbcali.LatamKG.repository.AeropuertoRepository;
import co.edu.usbcali.LatamKG.repository.TrayectoRepository;
import co.edu.usbcali.LatamKG.repository.VueloRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TrayectoServiceImpl implements TrayectoService {
    private final TrayectoRepository trayectoRepository;
    private final AeropuertoRepository aeropuertoRepository;

    private final VueloRepository vueloRepository;
    private final ModelMapper modelMapper;
    public TrayectoServiceImpl(TrayectoRepository trayectoRepository, ModelMapper modelMapper, AeropuertoRepository aeropuertoRepository, VueloRepository vueloRepository) {
        this.trayectoRepository = trayectoRepository;
        this.modelMapper = modelMapper;
        this.aeropuertoRepository = aeropuertoRepository;
        this.vueloRepository = vueloRepository;
    }
    @Override
    public TrayectoDTO obtenerTrayecto(Integer id) throws Exception {
        if (trayectoRepository.findById(id).isEmpty()) {
            throw new Exception("El id " + id + " no corresponde a ningun trayecto!");
        }
        return TrayectoMapper.domainToDTO(trayectoRepository.findById(id).get());
    }
    @Override
    public TrayectoDTO agregarTrayecto(TrayectoDTO trayectoDTO) throws Exception {
        if (trayectoDTO == null) {
            throw new Exception("El trayecto no es valido!");
        }
        if (trayectoDTO.getEstado() == null || trayectoDTO.getEstado().isBlank() || trayectoDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado del trayecto no es valido!");
        }
        Trayecto trayecto = TrayectoMapper.dtoToDomain(trayectoDTO);
        Aeropuerto origen = aeropuertoRepository.findById(trayectoDTO.getIdAeropuertoOrigen()).get();
        Aeropuerto destino = aeropuertoRepository.findById(trayectoDTO.getIdAeropuertoDestino()).get();
        Vuelo vuelo = vueloRepository.findById(trayectoDTO.getIdVuelo()).get();
        trayecto.setIdAeropuertoOrigen(origen);
        trayecto.setIdAeropuertoDestino(destino);
        trayecto.setIdVuelo(vuelo);
        return TrayectoMapper.domainToDTO(trayectoRepository.save(trayecto));
    }
    @Override
    public List<TrayectoDTO> obtenerTrayectos() {
        return TrayectoMapper.domainToDTOList(trayectoRepository.findAll());
    }
}

