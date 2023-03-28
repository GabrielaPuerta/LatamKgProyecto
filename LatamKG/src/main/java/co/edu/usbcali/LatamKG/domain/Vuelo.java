package co.edu.usbcali.LatamKG.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "vuelo")
public class Vuelo {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vuel_id", nullable = false, unique = true)
    private Integer idVuelo;
    @ManyToOne
    @JoinColumn(name = "id_aeropuerto_origen", referencedColumnName = "id_aeropuerto_origen")
    private Aeropuerto idAeropuertoOrigen;
    @ManyToOne
    @JoinColumn(name = "id_aeropuerto_destino", referencedColumnName = "id_aeropuerto_destino")
    private Aeropuerto idAeropuertoDestino;
    @Column(name = "precio", nullable = false)
    private long precio;
    @Column(name = "hora_salida", nullable = false)
    @CreationTimestamp
    private Date fechaHoraSalida;
    @Column(name = "hora_llegada", nullable = false)
    @CreationTimestamp
    private Date fechaHoraLlegada;
    @Column(name = "precio_asiento", nullable = false)
    private long precioAsientoEconomica;
    @Column(name = "precio_asiento", nullable = false)
    private long precioAsientoVip;
    @Column(name = "precio_asiento", nullable = false)
    private long precioAsientoPrimeraClase;
    @Column(name = "estado", nullable = false, length = 1)
    private String estado;
}