package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.domain.Avion;
import co.edu.usbcali.LatamKG.dto.AvionDTO;
import co.edu.usbcali.LatamKG.mapper.AvionMapper;
import co.edu.usbcali.LatamKG.repository.AvionRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AvionServiceImpl implements AvionService {
    private final AvionRepository avionRepository;
    private final ModelMapper modelMapper;
    public AvionServiceImpl(AvionRepository avionRepository, ModelMapper modelMapper) {
        this.avionRepository = avionRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<AvionDTO> obtenerAviones() {
        return AvionMapper.domainToDTOList(avionRepository.findAll());
    }
    @Override
    public AvionDTO obtenerAvion(Integer id) throws Exception {
        if (avionRepository.findById(id).isEmpty()) {
            throw new Exception("El id " + id + " no corresponde a ningun avion!");
        }
        return AvionMapper.domainToDTO(avionRepository.findById(id).get());
    }
    @Override
    public AvionDTO agregarAvion(AvionDTO avionDTO) throws Exception {
        if (avionDTO == null) {
            throw new Exception("El avión no es valido!");
        }
        if (avionDTO.getModelo() == null || avionDTO.getModelo().isBlank() || avionDTO.getModelo().trim().isEmpty()) {
            throw new Exception("Favor ingrese el nombre de la aerolinea del avion!");
        }
        if (avionDTO.getEstado() == null || avionDTO.getEstado().isBlank() || avionDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado no es valido!");
        }
        if(avionRepository.findById(avionDTO.getIdAvion()).isPresent()){
            throw new Exception("Ya existe el id del avion!");
        }
        Avion avion = AvionMapper.dtoToDomain(avionDTO);
        return AvionMapper.domainToDTO(avionRepository.save(avion));
    }
}