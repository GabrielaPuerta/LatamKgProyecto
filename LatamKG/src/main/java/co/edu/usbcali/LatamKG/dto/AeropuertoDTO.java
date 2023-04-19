package co.edu.usbcali.LatamKG.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class AeropuertoDTO {
    private  Integer aero_id;
    private String nombre;
    private String iata;
    private String ubicacion;
    private String estado;
}
