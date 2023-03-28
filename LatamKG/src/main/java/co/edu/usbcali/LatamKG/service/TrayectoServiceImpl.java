package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.domain.Trayecto;
import co.edu.usbcali.LatamKG.dto.TrayectoDTO;
import co.edu.usbcali.LatamKG.mapper.TrayectoMapper;
import co.edu.usbcali.LatamKG.repository.TrayectoRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class TrayectoServiceImpl implements TrayectoService {
    private final TrayectoRepository trayectoRepository;
    private final ModelMapper modelMapper;
    public TrayectoServiceImpl(TrayectoRepository trayectoRepository, ModelMapper modelMapper) {
        this.trayectoRepository = trayectoRepository;
        this.modelMapper = modelMapper;
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
        if(trayectoRepository.findById(trayectoDTO.getIdTrayecto()).isPresent()){
            throw new Exception("id del trayecto ya existente!");
        }
        Trayecto trayecto = TrayectoMapper.dtoToDomain(trayectoDTO);
        return TrayectoMapper.domainToDTO(trayectoRepository.save(trayecto));
    }
    @Override
    public List<TrayectoDTO> obtenerTrayectos() {
        return TrayectoMapper.domainToDTOList(trayectoRepository.findAll());
    }
}

