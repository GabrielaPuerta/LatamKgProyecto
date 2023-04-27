package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.domain.RolUsuario;
import co.edu.usbcali.LatamKG.domain.TipoAsiento;
import co.edu.usbcali.LatamKG.dto.RolUsuarioDTO;
import co.edu.usbcali.LatamKG.dto.TipoAsientoDTO;
import co.edu.usbcali.LatamKG.repository.TipoAsientoRepository;
import co.edu.usbcali.LatamKG.service.implementation.TipoAsientoServiceImpl;
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
public class TipoAsientoServiceImplTest {

    @InjectMocks
    private TipoAsientoServiceImpl tipoAsientoService;
    @Mock
    private TipoAsientoRepository tipoAsientoRepository;

    @Test
    public void obtenerTipoAsiento() throws Exception{
        TipoAsiento tipoAsiento = TipoAsiento.builder()
                .idTipoAsiento(3)
                .estado("A")
                .descripcion("latam")
                .build();

        given(tipoAsientoRepository.findById(3)).willReturn(Optional.of(tipoAsiento));

        TipoAsientoDTO tipoAsientoConsultado = tipoAsientoService.obtenerTipoAsiento(3);

        assertEquals(tipoAsientoConsultado.getIdTipoAsiento(), tipoAsiento.getIdTipoAsiento());
    }

    @Test
    public void obtenerTipoAsientos() {
        List<TipoAsiento> tipoAsientosRetorno = Arrays.asList(TipoAsiento.builder()
                .idTipoAsiento(3)
                .estado("A")
                .descripcion("latam")
                .build(), TipoAsiento.builder()
                        .descripcion("avianca")
                        .estado("B")
                        .idTipoAsiento(5)
                                .build());

        Mockito.when(tipoAsientoRepository.findAll()).thenReturn(tipoAsientosRetorno);

        List<TipoAsientoDTO> tipoAsiento = tipoAsientoService.obtenerTipoAsientos();

        assertEquals(2, tipoAsiento.size());
    }
}
