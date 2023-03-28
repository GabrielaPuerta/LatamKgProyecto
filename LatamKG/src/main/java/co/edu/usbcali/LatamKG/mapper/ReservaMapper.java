package co.edu.usbcali.LatamKG.mapper;

import co.edu.usbcali.LatamKG.domain.Reserva;
import co.edu.usbcali.LatamKG.dto.ReservaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReservaMapper {
    public static ReservaDTO domainToDTO(Reserva reserva) {
        return ReservaDTO.builder()
                .idReserva(reserva.getIdReserva())
                .idVuelo(reserva.getIdVuelo() != null ? reserva.getIdVuelo().getIdVuelo() : null)
                .precioTotal(reserva.getPrecioTotal())
                .estadoPago(reserva.getEstadoPago())
                .estado(reserva.getEstado())
                .build();
    }

    public static List<ReservaDTO> domainToDTOList(List<Reserva> reservas) {
        return reservas.stream().map(reserva -> domainToDTO(reserva)).collect(Collectors.toList());
    }

    public static Reserva dtoToDomain(ReservaDTO reservaDTO) {
        return Reserva.builder()
                .idReserva(reservaDTO.getIdReserva())
                .precioTotal(reservaDTO.getPrecioTotal())
                .estadoPago(reservaDTO.getEstadoPago())
                .estado(reservaDTO.getEstado())
                .build();
    }

    public static List<Reserva> dtoToDomainList(List<ReservaDTO> reservasDTO) {
        return reservasDTO.stream().map(reservaDTO -> dtoToDomain(reservaDTO)).collect(Collectors.toList());
    }
}
