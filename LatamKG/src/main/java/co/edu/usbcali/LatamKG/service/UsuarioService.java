package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> obtenerUsuarios();
    UsuarioDTO obtenerUsuario(Integer id) throws Exception;
    UsuarioDTO agregarUsuario(UsuarioDTO usuarioDTO) throws Exception;
}
