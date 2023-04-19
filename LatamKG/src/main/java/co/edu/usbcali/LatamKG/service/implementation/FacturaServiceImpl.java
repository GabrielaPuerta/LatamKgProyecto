package co.edu.usbcali.LatamKG.service.implementation;

import co.edu.usbcali.LatamKG.domain.Factura;
import co.edu.usbcali.LatamKG.domain.Reserva;
import co.edu.usbcali.LatamKG.domain.Usuario;
import co.edu.usbcali.LatamKG.repository.FacturaRepository;
import co.edu.usbcali.LatamKG.repository.ReservaRepository;
import co.edu.usbcali.LatamKG.repository.UsuarioRepository;
import co.edu.usbcali.LatamKG.service.FacturaService;
import lombok.extern.slf4j.Slf4j;
import co.edu.usbcali.LatamKG.dto.FacturaDTO;
import co.edu.usbcali.LatamKG.mapper.FacturaMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class FacturaServiceImpl implements FacturaService {
    private final FacturaRepository facturaRepository;
    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public FacturaServiceImpl(FacturaRepository facturaRepository, ReservaRepository reservaRepository, UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.facturaRepository = facturaRepository;
        this.reservaRepository = reservaRepository;
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<FacturaDTO> obtenerFacturas() {
        return FacturaMapper.domainToDTOList(facturaRepository.findAll());
    }
    @Override
    public FacturaDTO obtenerFactura(Integer id) throws Exception {
        if (facturaRepository.findById(id).isEmpty()) {
            throw new Exception("El id " + id + " no corresponde a ninguna factura");
        }
        return FacturaMapper.domainToDTO(facturaRepository.findById(id).get());
    }
    @Override
    public FacturaDTO agregarFactura(FacturaDTO facturaDTO) throws Exception {
        if (facturaDTO == null) {
            throw new Exception("La factura es invalida!");
        }
        if (facturaDTO.getEstado() == null || facturaDTO.getEstado().isBlank() || facturaDTO.getEstado().trim().isEmpty()) {
            throw new Exception("El estado es invalido!");
        }
        Factura factura = FacturaMapper.dtoToDomain(facturaDTO);
        Reserva reserva = reservaRepository.findById(facturaDTO.getIdReserva()).get();
        Usuario usuario = usuarioRepository.findById(facturaDTO.getIdUsuario()).get();
        factura.setReserva(reserva);
        factura.setUsuario(usuario);
        return FacturaMapper.domainToDTO(facturaRepository.save(factura));
    }
}