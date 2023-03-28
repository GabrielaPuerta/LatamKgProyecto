package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.domain.Vuelo;
import co.edu.usbcali.LatamKG.dto.VueloDTO;
import co.edu.usbcali.LatamKG.mapper.VueloMapper;
import co.edu.usbcali.LatamKG.repository.VueloRepository;
import org.modelmapper.ModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class VueloServiceImpl implements VueloService {
    private final VueloRepository vueloRepository;
    private final ModelMapper modelMapper;
    public VueloServiceImpl(VueloRepository vueloRepository, ModelMapper modelMapper) {
        this.vueloRepository = vueloRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<VueloDTO> obtenerVuelos() {
        return VueloMapper.domainToDTOList(vueloRepository.findAll());
    }
    @Override
    public VueloDTO guardarVuelo(VueloDTO vueloDTO) throws Exception {
        if (vueloDTO == null) {
            throw new Exception("El vuelo no puede ser nulo!");
        }
        if (vueloDTO.getPrecio() < 0) {
            throw new Exception("El precio del vuelo no puede ser negativo!");
        }
        if (vueloDTO.getIdVuelo() == null) {
            throw new Exception("El id del vuelo es invalido!");
        }
        if (vueloDTO.getFechaHoraSalida() == null) {
            throw new Exception("La hora de salida es invalida!");
        }
        if (vueloDTO.getFechaHoraLlegada() == null) {
            throw new Exception("La hora de llegada es invalida!");
        }
        if (vueloDTO.getPrecioAsientoEconomica() < 0) {
            throw new Exception("El precio del asiento preferencial no puede ser negativo!");
        }
        if (vueloDTO.getPrecioAsientoVip() < 0) {
            throw new Exception("El precio del asiento vip no puede ser negativo!");
        }
        if (vueloDTO.getPrecioAsientoPrimeraClase() < 0) {
            throw new Exception("El precio del asiento turista no puede ser negativo!");
        }
        if (vueloDTO.getEstado() == null || vueloDTO.getEstado().isBlank() || vueloDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado del vuelo es invalido!");
        }
        if(vueloRepository.findById(vueloDTO.getIdVuelo()).isPresent()){
            throw new Exception("Ya existe el id del vuelo!");
        }
        Vuelo vuelo = VueloMapper.dtoToDomain(vueloDTO);
        return VueloMapper.domainToDTO(vueloRepository.save(vuelo));
    }

    @Override
    public VueloDTO obtenerVuelo(Integer id) throws Exception {
        if (vueloRepository.findById(id).isEmpty()) {
            throw new Exception("El id " + id + " no corresponde a ningun vuelo!");
        }
        return VueloMapper.domainToDTO(vueloRepository.findById(id).get());
    }
}
