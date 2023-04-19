package co.edu.usbcali.LatamKG.mapper;

import co.edu.usbcali.LatamKG.domain.Vuelo;
import co.edu.usbcali.LatamKG.dto.VueloDTO;

import java.util.List;
import java.util.stream.Collectors;

public class VueloMapper {
    public static VueloDTO domainToDTO(Vuelo vuelo) {
        return VueloDTO.builder()
                .idVuelo(vuelo.getIdVuelo())
                .origen(vuelo.getOrigen())
                .destino(vuelo.getDestino())
                .precio(vuelo.getPrecio())
                .fechaHoraSalida(vuelo.getFechaHoraSalida())
                .fechaHoraLlegada(vuelo.getFechaHoraLlegada())
                .precioAsientoVip(vuelo.getPrecioAsientoVip())
                .precioAsientoBasico(vuelo.getPrecioAsientoBasico())
                .precioAsientoNormal(vuelo.getPrecioAsientoNormal())
                .estado(vuelo.getEstado())
                .avion(vuelo.getAvion())
                .build();
    }

    public static List<VueloDTO> domainToDTOList(List<Vuelo> vuelos) {
        return vuelos.stream().map(vuelo -> domainToDTO(vuelo)).collect(Collectors.toList());
    }

    public static Vuelo dtoToDomain(VueloDTO vueloDTO) {
        return Vuelo.builder()
                .idVuelo(vueloDTO.getIdVuelo())
                .precio(vueloDTO.getPrecio())
                .origen(vueloDTO.getOrigen())
                .destino(vueloDTO.getDestino())
                .fechaHoraSalida(vueloDTO.getFechaHoraSalida())
                .fechaHoraLlegada(vueloDTO.getFechaHoraLlegada())
                .precioAsientoVip(vueloDTO.getPrecioAsientoVip())
                .precioAsientoBasico(vueloDTO.getPrecioAsientoBasico())
                .precioAsientoNormal(vueloDTO.getPrecioAsientoNormal())
                .estado(vueloDTO.getEstado())
                .build();
    }

    public static List<Vuelo> dtoToDomainList(List<VueloDTO> vuelosDTO) {
        return vuelosDTO.stream().map(vueloDTO -> dtoToDomain(vueloDTO)).collect(Collectors.toList());
    }
}