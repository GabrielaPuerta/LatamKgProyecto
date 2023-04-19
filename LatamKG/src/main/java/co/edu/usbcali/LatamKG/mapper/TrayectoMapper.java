package co.edu.usbcali.LatamKG.mapper;

import co.edu.usbcali.LatamKG.domain.Trayecto;
import co.edu.usbcali.LatamKG.dto.TrayectoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class TrayectoMapper {
    public static TrayectoDTO domainToDTO(Trayecto trayecto) {
        return TrayectoDTO.builder()
                .idTrayecto(trayecto.getIdTrayecto())
                .idAeropuertoOrigen(trayecto.getIdAeropuertoOrigen() != null ? trayecto.getIdAeropuertoOrigen().getAeroId() : null)
                .idAeropuertoDestino(trayecto.getIdAeropuertoDestino() != null ? trayecto.getIdAeropuertoDestino().getAeroId() : null)
                .idVuelo(trayecto.getIdVuelo().getIdVuelo())
                .estado(trayecto.getEstado())
                .build();
    }

    public static List<TrayectoDTO> domainToDTOList(List<Trayecto> trayectos) {
        return trayectos.stream().map(trayecto -> domainToDTO(trayecto)).collect(Collectors.toList());
    }

    public static Trayecto dtoToDomain(TrayectoDTO trayectoDTO) {
        return Trayecto.builder()
                .idTrayecto(trayectoDTO.getIdTrayecto())
                .estado(trayectoDTO.getEstado())
                .build();
    }

    public static List<Trayecto> dtoToDomainList(List<TrayectoDTO> trayectosDTO) {
        return trayectosDTO.stream().map(trayectoDTO -> dtoToDomain(trayectoDTO)).collect(Collectors.toList());
    }
}
