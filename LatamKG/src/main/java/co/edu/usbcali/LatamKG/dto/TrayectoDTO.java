package co.edu.usbcali.LatamKG.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;


@Data
@AllArgsConstructor
@Builder
@ToString
public class TrayectoDTO {
    private Integer idTrayecto;
    private Integer idAeropuertoDestino;
    private Integer idAeropuertoOrigen;
    private Integer idVuelo;
    private String estado;
}
