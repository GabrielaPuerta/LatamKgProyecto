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
@Table(name = "reserva")
public class Reserva {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rese_id", nullable = false, unique = true)
    private Integer idReserva;
    @ManyToOne
    @JoinColumn(name = "vuel_id", referencedColumnName = "vuel_id")
    private Vuelo vuelo;
    @Column(name = "precio_total", nullable = false)
    private long precioTotal;
    @Column(name = "estado_pago", nullable = false, length = 1)
    private String estadoPago;
    @Column(name = "estado", nullable = false, length = 1)
    private String estado;
}
