package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.domain.RolUsuario;
import co.edu.usbcali.LatamKG.dto.RolUsuarioDTO;
import co.edu.usbcali.LatamKG.mapper.RolUsuarioMapper;
import co.edu.usbcali.LatamKG.repository.RolUsuarioRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class RolUsuarioServiceImpl implements  RolUsuarioService {
    private final RolUsuarioRepository rolUsuarioRepository;
    private final ModelMapper modelMapper;

    public RolUsuarioServiceImpl(RolUsuarioRepository rolUsuarioRepository, ModelMapper modelMapper) {
        this.rolUsuarioRepository = rolUsuarioRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<RolUsuarioDTO> obtenerTodos() {
        List<RolUsuario> RolUsuarios =
                rolUsuarioRepository.findAll();

        return RolUsuarioMapper.domainToDtoList(RolUsuarios);
    }

    @Override
    public RolUsuarioDTO guardarNuevoRolUsuario(RolUsuarioDTO rolUsuarioDTO) throws Exception {
        //Validar DTO
        if (rolUsuarioDTO == null) {
            throw new Exception("El rol usuario puede ser nulo");
        }
        if (rolUsuarioDTO.getId() == null ||
                rolUsuarioDTO.getId().equals(0)) {
            throw new Exception("Id no puede ser nulo o 0");
        }
        if (rolUsuarioDTO.getDescripcion() == null ||
                rolUsuarioDTO.getDescripcion().trim().isEmpty()) {
            throw new Exception("Descripcion no puede ser nulo o 0");
        }
        if (rolUsuarioDTO.getEstado() == null ||
                rolUsuarioDTO.getEstado().trim().isEmpty()) {
            throw new Exception("Estado no puede ser nulo o 0");
        }
        //Convertir DTO a Modelo
        RolUsuario rolUsuario = RolUsuarioMapper.dtoToDomain((rolUsuarioDTO));
        return RolUsuarioMapper.domainToDto(rolUsuarioRepository.save(rolUsuario));
    }

    @Override
    public RolUsuarioDTO obtenerRolUsuario(Integer id) throws Exception {
        if (rolUsuarioRepository.findById(id).isEmpty()){
            throw new Exception("El id"+ id + "no corresponde a ningun usuario!");
        }
        return RolUsuarioMapper.domainToDto(rolUsuarioRepository.findById(id).get());
    }
}
