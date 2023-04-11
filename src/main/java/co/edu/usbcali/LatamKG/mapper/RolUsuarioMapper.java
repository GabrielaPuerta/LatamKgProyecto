package co.edu.usbcali.LatamKG.mapper;

import co.edu.usbcali.LatamKG.dto.RolUsuarioDTO;
import co.edu.usbcali.LatamKG.domain.RolUsuario;

import java.util.List;
import java.util.stream.Collectors;

public class RolUsuarioMapper {
    public static RolUsuarioDTO domainToDto(RolUsuario rolUsuario){
        return  RolUsuarioDTO.builder()
                .id(rolUsuario.getId())
                .descripcion(rolUsuario.getDescripcion())
                .estado(rolUsuario.getEstado())
                .build();
    }

    public  static RolUsuario dtoToDomain(RolUsuarioDTO rolUsuarioDTO){
        return RolUsuario.builder()
                .id(rolUsuarioDTO.getId())
                .descripcion(rolUsuarioDTO.getDescripcion())
                .estado(rolUsuarioDTO.getEstado())
                .build();
    }
    public static List<RolUsuarioDTO>domainToDtoList(List<RolUsuario> rolUsuarios){
        return rolUsuarios.stream().map(ru -> domainToDto(ru)).collect(Collectors.toList());
    }
    public static List<RolUsuario> dtoToModelList(List<RolUsuarioDTO> rolUsuarioDTOS){
        return rolUsuarioDTOS.stream().map(ru ->dtoToDomain(ru)).collect(Collectors.toList());
    }
}
