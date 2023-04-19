package co.edu.usbcali.LatamKG.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "aeropuerto")
public class Aeropuerto {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "aero_id")
    private Integer aeroId;
    @Column(nullable = false, length = 30)
    private String nombre;
    @Column(nullable = false, length = 1)
    private String estado;
    @Column(nullable = false, length = 30)
    private String iata;

    @Column(nullable = false, length = 30)
    private String ubicacion;


}