package co.edu.usbcali.LatamKG.service;


import co.edu.usbcali.LatamKG.domain.Avion;
import co.edu.usbcali.LatamKG.dto.AeropuertoDTO;
import co.edu.usbcali.LatamKG.dto.AvionDTO;
import co.edu.usbcali.LatamKG.repository.AvionRepository;
import co.edu.usbcali.LatamKG.service.implementation.AvionServiceImpl;
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
public class AvionServiceImplTest {
    @InjectMocks
    AvionServiceImpl avionService;
    @Mock
    private AvionRepository avionRepository;

    @Test
    public void obtenerAvionesTest(){
        List<Avion> avionesRetorno = Arrays.asList(Avion.builder()
                        .idAvion(2)
                        .estado("A")
                        .modelo("latam")
                .build(), Avion.builder()
                        .idAvion(3)
                        .estado("B")
                        .modelo("avianca")
                .build());

        Mockito.when(avionRepository.findAll()).thenReturn(avionesRetorno);

        List<AvionDTO> aviones = avionService.obtenerAviones();

        assertEquals(2, aviones.size());
    }
    @Test
    public void obtenerAvionTest() throws Exception{
        Avion avion = Avion.builder()
                .idAvion(2)
                .modelo("latam")
                .estado("A")
                .build();

        given(avionRepository.findById(2)).willReturn(Optional.of(avion));

        AvionDTO avionConsultado = avionService.obtenerAvion(2);

        assertEquals(avionConsultado.getEstado(), avion.getEstado());
    }
}
