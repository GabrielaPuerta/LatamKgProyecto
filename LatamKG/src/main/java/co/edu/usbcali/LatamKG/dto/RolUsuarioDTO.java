package co.edu.usbcali.LatamKG.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@ToString
public class RolUsuarioDTO {
    private  Integer id;
    private String descripcion;
    private String estado;
}
