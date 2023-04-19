package co.edu.usbcali.LatamKG.mapper;

import co.edu.usbcali.LatamKG.dto.AeropuertoDTO;
import co.edu.usbcali.LatamKG.domain.Aeropuerto;

import java.util.List;
import java.util.stream.Collectors;

public class AeropuertoMapper {
    public static AeropuertoDTO domainToDto(Aeropuerto aeropuerto){
        return  AeropuertoDTO.builder()
                .aero_id(aeropuerto.getAeroId())
                .nombre(aeropuerto.getNombre())
                .iata(aeropuerto.getIata())
                .estado(aeropuerto.getEstado())
                .ubicacion(aeropuerto.getUbicacion())
                .build();
    }

    public  static Aeropuerto dtoToDomain(AeropuertoDTO aeropuertoDTO){
        return Aeropuerto.builder()
               .aeroId(aeropuertoDTO.getAero_id() != null ? aeropuertoDTO.getAero_id() : null)
                .nombre(aeropuertoDTO.getNombre())
                .iata(aeropuertoDTO.getIata())
                .estado(aeropuertoDTO.getEstado())
                .ubicacion(aeropuertoDTO.getUbicacion())
                .build();
    }
    public static List<AeropuertoDTO> domainToDtoList(List<Aeropuerto> aeropuertos){
        return aeropuertos.stream().map(ae -> domainToDto(ae)).collect(Collectors.toList());
    }
    public static List<Aeropuerto> dtoToDomainList(List<AeropuertoDTO> aeropuertoDTOS){
        return aeropuertoDTOS.stream().map(ae -> dtoToDomain(ae)).collect(Collectors.toList());
    }

}

