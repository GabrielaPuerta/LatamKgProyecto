package co.edu.usbcali.LatamKG.mapper;

import co.edu.usbcali.LatamKG.domain.Vuelo;
import co.edu.usbcali.LatamKG.dto.VueloDTO;

import java.util.List;
import java.util.stream.Collectors;

public class VueloMapper {
    public static VueloDTO domainToDTO(Vuelo vuelo) {
        return VueloDTO.builder()
                .idVuelo(vuelo.getIdVuelo())
                .idAeropuertoOrigen(Math.toIntExact(vuelo.getIdAeropuertoOrigen() != null ? vuelo.getIdAeropuertoOrigen().getAero_id() : null))
                .idAeropuertoDestino(Math.toIntExact(vuelo.getIdAeropuertoDestino() != null ? vuelo.getIdAeropuertoDestino().getAero_id() : null))
                .precio(vuelo.getPrecio())
                .fechaHoraSalida(vuelo.getFechaHoraSalida())
                .fechaHoraLlegada(vuelo.getFechaHoraLlegada())
                .precioAsientoEconomica(vuelo.getPrecioAsientoEconomica())
                .precioAsientoVip(vuelo.getPrecioAsientoVip())
                .precioAsientoPrimeraClase(vuelo.getPrecioAsientoPrimeraClase())
                .estado(vuelo.getEstado())
                .build();
    }

    public static List<VueloDTO> domainToDTOList(List<Vuelo> vuelos) {
        return vuelos.stream().map(vuelo -> domainToDTO(vuelo)).collect(Collectors.toList());
    }

    public static Vuelo dtoToDomain(VueloDTO vueloDTO) {
        return Vuelo.builder()
                .idVuelo(vueloDTO.getIdVuelo())
                .precio(vueloDTO.getPrecio())
                .fechaHoraSalida(vueloDTO.getFechaHoraSalida())
                .fechaHoraLlegada(vueloDTO.getFechaHoraLlegada())
                .precioAsientoEconomica(vueloDTO.getPrecioAsientoEconomica())
                .precioAsientoVip(vueloDTO.getPrecioAsientoVip())
                .precioAsientoPrimeraClase(vueloDTO.getPrecioAsientoPrimeraClase())
                .estado(vueloDTO.getEstado())
                .build();
    }

    public static List<Vuelo> dtoToDomainList(List<VueloDTO> vuelosDTO) {
        return vuelosDTO.stream().map(vueloDTO -> dtoToDomain(vueloDTO)).collect(Collectors.toList());
    }
}