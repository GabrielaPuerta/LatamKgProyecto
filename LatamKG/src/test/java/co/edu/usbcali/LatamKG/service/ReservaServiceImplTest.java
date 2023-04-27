package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.domain.Avion;
import co.edu.usbcali.LatamKG.domain.Reserva;
import co.edu.usbcali.LatamKG.domain.Vuelo;
import co.edu.usbcali.LatamKG.dto.ReservaDTO;
import co.edu.usbcali.LatamKG.dto.VueloDTO;
import co.edu.usbcali.LatamKG.repository.ReservaRepository;
import co.edu.usbcali.LatamKG.repository.VueloRepository;
import co.edu.usbcali.LatamKG.service.implementation.ReservaServiceImpl;
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
public class ReservaServiceImplTest {
    @InjectMocks
    private ReservaServiceImpl reservaService;
    @Mock
    private  ReservaRepository reservaRepository;
    @Mock
    private  VueloRepository vueloRepository;

    @Test
    public void obtenerReservasTest(){
        Vuelo vuelo = Vuelo.builder()
                .idVuelo(4)
                .precio(500000)
                .precioAsientoNormal(120000)
                .precioAsientoBasico(150000)
                .precioAsientoVip(200000)
                .fechaHoraSalida(new Date("12/08/2023"))
                .fechaHoraLlegada(new Date("14/08/2023"))
                .origen("cali")
                .destino("peru")
                .estado("A")
                .avion(Avion.builder()
                        .idAvion(3)
                        .modelo("BOEING777")
                        .estado("A")
                        .build())
                .build();
        Reserva reservasRetorno = Reserva.builder()
                .vuelo(vuelo)
                .precioTotal(230000)
                .estadoPago("Completado")
                .idReserva(12)
                .estado("A")
                .build();

        Mockito.when(reservaRepository.findAll()).thenReturn(Arrays.asList(reservasRetorno));

        List<ReservaDTO> reservas = reservaService.obtenerReservas();

        assertEquals(1, reservas.size());
    }

    @Test
    public void obtenerReservaTest() throws Exception{
        Vuelo vuelo = Vuelo.builder()
                .idVuelo(4)
                .precio(500000)
                .precioAsientoNormal(120000)
                .precioAsientoBasico(150000)
                .precioAsientoVip(200000)
                .fechaHoraSalida(new Date("12/08/2023"))
                .fechaHoraLlegada(new Date("14/08/2023"))
                .origen("cali")
                .destino("peru")
                .estado("A")
                .avion(Avion.builder()
                        .idAvion(3)
                        .modelo("BOEING777")
                        .estado("A")
                        .build())
                .build();
        Reserva reserva = Reserva.builder()
                .vuelo(vuelo)
                .precioTotal(230000)
                .estadoPago("Completado")
                .idReserva(12)
                .estado("A")
                .build();

        given(reservaRepository.findById(4)).willReturn(Optional.of(reserva));

        ReservaDTO reservaConsultada = reservaService.obtenerReserva(4);

        assertEquals(reservaConsultada.getIdReserva(), reserva.getIdReserva());
    }
}
