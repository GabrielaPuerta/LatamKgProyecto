package co.edu.usbcali.LatamKG.service;

import co.edu.usbcali.LatamKG.domain.RolUsuario;
import co.edu.usbcali.LatamKG.dto.RolUsuarioDTO;
import co.edu.usbcali.LatamKG.repository.RolUsuarioRepository;
import co.edu.usbcali.LatamKG.service.implementation.RolUsuarioServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.BDDMockito.given;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RolUsuarioServiceImplTest {
    @InjectMocks
    private RolUsuarioServiceImpl rolUsuarioService;
    @Mock
    private RolUsuarioRepository rolUsuarioRepository;
    @Test
    public void obtenerRolUsuarioTest() throws Exception {
        RolUsuario rolUsuario = RolUsuario.builder()
                .estado("Inactivo")
                .descripcion("gerente")
                .id(3).build();

        given(rolUsuarioRepository.findById(3)).willReturn(Optional.of(rolUsuario));

        RolUsuarioDTO rolUsuarioConsultado = rolUsuarioService.obtenerRolUsuario(3);

        assertEquals(rolUsuarioConsultado.getDescripcion(), rolUsuario.getDescripcion());
    }
    @Test
    public void obtenerTodosTest(){

        List<RolUsuario> rolUsuariosRetorno = Arrays.asList(RolUsuario.builder()
                .id(4)
                .estado("Activo")
                .descripcion("ADMIN")
                .build(), RolUsuario.builder()
                .id(3)
                .estado("Activo")
                .descripcion("Gerente")
                .build());

        Mockito.when(rolUsuarioRepository.findAll()).thenReturn(rolUsuariosRetorno);

        List<RolUsuarioDTO> rolUsuarios = rolUsuarioService.obtenerTodos();

        assertEquals(2, rolUsuarios.size());
    }
}
