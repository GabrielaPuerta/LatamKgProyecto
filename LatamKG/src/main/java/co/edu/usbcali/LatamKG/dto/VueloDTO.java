package co.edu.usbcali.LatamKG.dto;

import java.util.Date;

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
    private Integer idAeropuertoOrigen;
    private Integer idAeropuertoDestino;
    private long precio;
    private Date fechaHoraSalida;
    private Date fechaHoraLlegada;
    private long precioAsientoEconomica;
    private long precioAsientoVip;
    private long precioAsientoPrimeraClase;
    private String estado;

}