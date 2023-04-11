package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.dto.RolUsuarioDTO;

import java.util.List;

public interface RolUsuarioService {
    List<RolUsuarioDTO> obtenerTodos();

    RolUsuarioDTO guardarNuevoRolUsuario(RolUsuarioDTO rolUsuarioDTO) throws Exception;
    RolUsuarioDTO obtenerRolUsuario(Integer id) throws Exception;

    }

