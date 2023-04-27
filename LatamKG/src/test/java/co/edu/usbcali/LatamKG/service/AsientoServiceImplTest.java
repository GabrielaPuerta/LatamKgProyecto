package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.domain.*;
import co.edu.usbcali.LatamKG.dto.AsientoDTO;
import co.edu.usbcali.LatamKG.repository.AsientoRepository;
import co.edu.usbcali.LatamKG.repository.ReservaRepository;
import co.edu.usbcali.LatamKG.repository.TipoAsientoRepository;
import co.edu.usbcali.LatamKG.service.implementation.AsientoServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class AsientoServiceImplTest {
    @InjectMocks
    AsientoServiceImpl asientoService;
    @Mock
    private AsientoRepository asientoRepository;
    @Mock
    private TipoAsientoRepository tipoAsientoRepository;
    @Mock
    private ReservaRepository reservaRepository;


    @Test
    public void obtenerAsientosTest(){
        TipoAsiento tipoAsiento = TipoAsiento.builder()
                .idTipoAsiento(3)
                .descripcion("VIP")
                .estado("A")
                .build();
        Reserva reserva = Reserva.builder()
                .idReserva(5)
                .estadoPago("A")
                .precioTotal(140000)
                .vuelo(Vuelo.builder()
                        .destino("Cali")
                        .origen("Bogotá")
                        .avion(Avion.builder()
                                .idAvion(2)
                                .estado("A")
                                .modelo("latam")
                                .build())
                        .precio(110000)
                        .idVuelo(3)
                        .fechaHoraSalida(new Date("12/02/2023"))
                        .fechaHoraLlegada(new Date("13/02/2023"))
                        .precioAsientoVip(200000)
                        .precioAsientoBasico(130000)
                        .precioAsientoNormal(100000)
                        .estado("A")
                        .build()).build();
        Asiento asientosRetorno = Asiento.builder()
                .tipoAsiento(tipoAsiento)
                .idAsiento(3)
                .precio(140000)
                .ubicacion("27A")
                .estado("A")
                .reserva(reserva)
                        .build();

        Mockito.when(asientoRepository.findAll()).thenReturn(Arrays.asList(asientosRetorno));

        List<AsientoDTO> asientos = asientoService.obtenerAsientos();

        assertEquals(1, asientos.size());
    }

    @Test
    public void obtenerAsientoTest() throws Exception {
        TipoAsiento tipoAsiento = TipoAsiento.builder()
                .idTipoAsiento(3)
                .descripcion("VIP")
                .estado("A")
                .build();
        Reserva reserva = Reserva.builder()
                .idReserva(5)
                .estadoPago("A")
                .precioTotal(140000)
                .vuelo(Vuelo.builder()
                        .destino("Cali")
                        .origen("Bogotá")
                        .avion(Avion.builder()
                                .idAvion(2)
                                .estado("A")
                                .modelo("latam")
                                .build())
                        .precio(110000)
                        .idVuelo(3)
                        .fechaHoraSalida(new Date("12/02/2023"))
                        .fechaHoraLlegada(new Date("13/02/2023"))
                        .precioAsientoVip(200000)
                        .precioAsientoBasico(130000)
                        .precioAsientoNormal(100000)
                        .estado("A")
                        .build()).build();
        Asiento asiento = Asiento.builder()
                .tipoAsiento(tipoAsiento)
                .idAsiento(3)
                .precio(140000)
                .ubicacion("27A")
                .estado("A")
                .reserva(reserva)
                .build();

        given(asientoRepository.findById(3)).willReturn(Optional.of(asiento));

        AsientoDTO asientoConsultado = asientoService.obtenerAsiento(3);

        assertEquals(asientoConsultado.getIdAsiento(), asiento.getIdAsiento());

    }

}
