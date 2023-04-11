package co.edu.usbcali.LatamKG.mapper;

import co.edu.usbcali.LatamKG.domain.Factura;
import co.edu.usbcali.LatamKG.dto.FacturaDTO;

import java.util.List;
import java.util.stream.Collectors;

public class FacturaMapper {
    public static FacturaDTO domainToDTO(Factura factura) {
        return FacturaDTO.builder()
                .idFactura(factura.getIdFactura())
                .idUsuario(factura.getUsuario() != null ? factura.getUsuario().getUsuaId() : null)
                .idReserva(factura.getReserva() != null ? factura.getReserva().getIdReserva() : null)
                .estado(factura.getEstado())
                .build();
    }

    public static List<FacturaDTO> domainToDTOList(List<Factura> facturas) {
        return facturas.stream().map(factura -> domainToDTO(factura)).collect(Collectors.toList());
    }

    public static Factura dtoToDomain(FacturaDTO facturaDTO) {
        return Factura.builder()
                .idFactura(facturaDTO.getIdFactura())
                .estado(facturaDTO.getEstado())
                .build();
    }

    public static List<Factura> dtoToDomainList(List<FacturaDTO> facturasDTO) {
        return facturasDTO.stream().map(facturaDTO -> dtoToDomain(facturaDTO)).collect(Collectors.toList());
    }
}