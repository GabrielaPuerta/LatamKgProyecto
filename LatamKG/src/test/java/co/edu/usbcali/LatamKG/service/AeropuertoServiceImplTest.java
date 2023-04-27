package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.domain.Aeropuerto;
import co.edu.usbcali.LatamKG.dto.AeropuertoDTO;
import co.edu.usbcali.LatamKG.repository.AeropuertoRepository;
import co.edu.usbcali.LatamKG.service.implementation.AeropuertoServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class AeropuertoServiceImplTest {

    @InjectMocks
    private AeropuertoServiceImpl aeropuertoService;
    @Mock
    private AeropuertoRepository aeropuertoRepository;


    @Test
    public void obtenerAeropuertosTest() {
        List<Aeropuerto> aeropuertosRetorno = Arrays.asList(Aeropuerto.builder()
                .nombre("Alfonso Bonilla")
                .iata("COL")
                .aeroId(3)
                .ubicacion("Cali")
                .estado("A")
                .build(), Aeropuerto.builder()
                        .nombre("Alfonso Bonilla")
                        .iata("COL")
                        .aeroId(3)
                        .ubicacion("Cali")
                        .estado("A")
                        .build());

        Mockito.when(aeropuertoRepository.findAll()).thenReturn(aeropuertosRetorno);

        List<AeropuertoDTO> aeropuertos = aeropuertoService.obtenerAeropuertos();

        assertEquals(2, aeropuertos.size());
    }
    @Test
    public void obtenerAeropuertoTest() throws Exception{
        Aeropuerto aeropuerto = Aeropuerto.builder()
                .nombre("Aeropuerto Vanguardia")
                .iata("VVC")
                .aeroId(4)
                .ubicacion("Villavicencio")
                .estado("A")
                .build();

        given(aeropuertoRepository.findById(4)).willReturn(Optional.of(aeropuerto));

        AeropuertoDTO aeropuertoConsultado = aeropuertoService.obtenerAeropuerto(4);

        assertEquals(aeropuertoConsultado.getUbicacion(), aeropuerto.getUbicacion());
    }


}
