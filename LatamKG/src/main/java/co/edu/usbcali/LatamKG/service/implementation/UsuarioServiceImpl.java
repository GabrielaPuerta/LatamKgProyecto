package co.edu.usbcali.LatamKG.service.implementation;

import co.edu.usbcali.LatamKG.domain.RolUsuario;
import co.edu.usbcali.LatamKG.domain.Usuario;
import co.edu.usbcali.LatamKG.dto.UsuarioDTO;
import co.edu.usbcali.LatamKG.mapper.UsuarioMapper;
import co.edu.usbcali.LatamKG.repository.RolUsuarioRepository;
import co.edu.usbcali.LatamKG.repository.UsuarioRepository;

import co.edu.usbcali.LatamKG.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;
    private final RolUsuarioRepository rolUsuarioRepository;
    private final ModelMapper modelMapper;
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, RolUsuarioRepository rolUsuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.rolUsuarioRepository = rolUsuarioRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        if (usuarioDTO == null) {
            throw new Exception("El usuario no es valido!");
        }
        if (usuarioDTO.getCedula() == null || usuarioDTO.getCedula().isBlank()) {
            throw new Exception("La cédula del usuario no es valida!");
        }
        if (usuarioDTO.getNombre() == null || usuarioDTO.getNombre().isBlank() || usuarioDTO.getNombre().trim().isEmpty()) {
            throw new Exception("El nombre del usuario no es valido!");
        }
        if (usuarioDTO.getApellido() == null || usuarioDTO.getApellido().isBlank() || usuarioDTO.getApellido().trim().isEmpty()) {
            throw new Exception("El apellido del usuario no es valido!");
        }
        if (usuarioDTO.getCorreo() == null || usuarioDTO.getCorreo().isBlank() || usuarioDTO.getCorreo().trim().isEmpty()) {
            throw new Exception("El correo del usuario no es valido!");
        }
        if (usuarioDTO.getEstado() == null || usuarioDTO.getEstado().isBlank() || usuarioDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado del usuario no es valido!");
        }
        if(usuarioRepository.findById(usuarioDTO.getUsuaId()).isPresent()){
            throw new Exception(" id del usuario ya existente");
        }
        Usuario usuario = UsuarioMapper.dtoToDomain(usuarioDTO);
        RolUsuario rolUsuario = rolUsuarioRepository.findById(usuarioDTO.getIdRolUsuario()).get();
        usuario.setRolUsuario(rolUsuario);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return UsuarioMapper.domainToDTO(usuarioGuardado);
    }
    @Override
    public List<UsuarioDTO> obtenerUsuarios() {
        return UsuarioMapper.domainToDTOList(usuarioRepository.findAll());
    }
    @Override
    public UsuarioDTO obtenerUsuario(Integer id) throws Exception {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (!usuario.isPresent()) {
            throw new Exception("El id " + id + " no corresponde a ningun usuario!");
        }

        return UsuarioMapper.domainToDTO(usuario.get());
    }
}