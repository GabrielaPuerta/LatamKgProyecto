package co.edu.usbcali.LatamKG.mapper;

import co.edu.usbcali.LatamKG.domain.Asiento;
import co.edu.usbcali.LatamKG.dto.AsientoDTO;

import java.util.List;
import java.util.stream.Collectors;

public class AsientoMapper {
    public static AsientoDTO domainToDTO(Asiento asiento) {
        return AsientoDTO.builder()
                .idAsiento(asiento.getIdAsiento())
                .idTipoAsiento(asiento.getIdTipoAsiento() != null ? asiento.getIdTipoAsiento().getIdTipoAsiento() : null)
                .idAvion(asiento.getIdAvion() != null ? asiento.getIdAvion().getIdAvion() : null)
                .ubicacion(asiento.getUbicacion())
                .precio(asiento.getPrecio())
                .estado(asiento.getEstado())
                .build();
    }
    public static List<AsientoDTO> domainToDTOList(List<Asiento> asientos) {
        return asientos.stream().map(asiento -> domainToDTO(asiento)).collect(Collectors.toList());
    }
    public static Asiento dtoToDomain(AsientoDTO asientoDTO) {
        return Asiento.builder()
                .idAsiento(asientoDTO.getIdAsiento())
                .ubicacion(asientoDTO.getUbicacion())
                .precio(asientoDTO.getPrecio())
                .estado(asientoDTO.getEstado())
                .build();
    }
    public static List<Asiento> dtoToDomainList(List<AsientoDTO> asientosDTO) {
        return asientosDTO.stream().map(asientoDTO -> dtoToDomain(asientoDTO)).collect(Collectors.toList());
    }
}
