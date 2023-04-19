package co.edu.usbcali.LatamKG.mapper;

import co.edu.usbcali.LatamKG.domain.Reserva;
import co.edu.usbcali.LatamKG.dto.ReservaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ReservaMapper {
    public static ReservaDTO domainToDTO(Reserva reserva) {
        return ReservaDTO.builder()
                .idReserva(reserva.getIdReserva())
                .idVuelo(reserva.getVuelo() != null ? reserva.getVuelo().getIdVuelo() : null)
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
                //agregando mapeo del id si viene presente en el DTO, de ser asi
                // lo setea y como ya existe actualiza los datos
                .idReserva(reservaDTO.getIdReserva() != null ? reservaDTO.getIdReserva() : null)
                .estadoPago(reservaDTO.getEstadoPago())
                .estado(reservaDTO.getEstado())
                .build();
    }

    public static List<Reserva> dtoToDomainList(List<ReservaDTO> reservasDTO) {
        return reservasDTO.stream().map(reservaDTO -> dtoToDomain(reservaDTO)).collect(Collectors.toList());
    }
}
