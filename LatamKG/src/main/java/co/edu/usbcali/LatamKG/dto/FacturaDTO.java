
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
public class FacturaDTO {
    private Integer idFactura;
    private Integer idUsuario;

    private Integer idReserva;
    private String estado;
}
