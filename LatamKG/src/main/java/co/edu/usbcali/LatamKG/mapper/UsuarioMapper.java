package co.edu.usbcali.LatamKG.mapper;

import co.edu.usbcali.LatamKG.domain.Usuario;
import co.edu.usbcali.LatamKG.dto.UsuarioDTO;

import java.util.List;
import java.util.stream.Collectors;

public class UsuarioMapper {

    public static UsuarioDTO domainToDTO(Usuario usuario) {
        return UsuarioDTO.builder()
                .usuaId(usuario.getUsuaId())
                .idRolUsuario(usuario.getRolUsuario() != null ? usuario.getRolUsuario().getId() : null)
                .cedula(usuario.getCedula())
                .nombre(usuario.getNombre())
                .apellido(usuario.getApellido())
                .correo(usuario.getCorreo())
                .estado(usuario.getEstado())
                .build();
    }

    public static List<UsuarioDTO> domainToDTOList(List<Usuario> usuarios) {
        //return usuarios.stream().map(usuario -> domainToDTO(usuario)).collect(Collectors.toList());
        return usuarios.stream().map(UsuarioMapper::domainToDTO).toList();
    }

    public static Usuario dtoToDomain(UsuarioDTO usuarioDTO) {
        return Usuario.builder()
                .usuaId(usuarioDTO.getUsuaId())
                .cedula(usuarioDTO.getCedula())
                .nombre(usuarioDTO.getNombre())
                .apellido(usuarioDTO.getApellido())
                .correo(usuarioDTO.getCorreo())
                .estado(usuarioDTO.getEstado())
                .build();
    }

    public static List<Usuario> dTOToDomainList(List<UsuarioDTO> usuariosDTO) {
        return usuariosDTO.stream().map(usuarioDTO -> dtoToDomain(usuarioDTO)).collect(Collectors.toList());
        //return usuariosDTO.stream().map(UsuarioMapper::dtoToDomain).toList();
    }


}
