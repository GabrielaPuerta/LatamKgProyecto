package co.edu.usbcali.LatamKG.dto;

import java.util.Date;

import co.edu.usbcali.LatamKG.domain.Avion;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class VueloDTO {
    private Integer idVuelo;
    private String origen;
    private String destino;
    private long precio;
    private Date fechaHoraSalida;
    private Date fechaHoraLlegada;
    private long precioAsientoBasico;
    private long precioAsientoVip;
    private long precioAsientoNormal;
    private String estado;
    private Avion avion;
}