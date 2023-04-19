package co.edu.usbcali.LatamKG.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
@ToString
public class ReservaDTO {
    private Integer idReserva;
    private Integer idVuelo;
    private long precioTotal;
    private String estadoPago;
    private String estado;
}
