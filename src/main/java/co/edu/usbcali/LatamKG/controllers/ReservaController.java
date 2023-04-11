package co.edu.usbcali.LatamKG.controllers;

import co.edu.usbcali.LatamKG.dto.MessageVuelo;
import co.edu.usbcali.LatamKG.dto.ReservaDTO;
import co.edu.usbcali.LatamKG.service.ReservaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
@Slf4j
public class ReservaController {
    private final ReservaService reservaService;
    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }
    @GetMapping("/obtenerReservas")
    public ResponseEntity<List<ReservaDTO>> obtenerReservas() {
        return new ResponseEntity(reservaService.obtenerReservas(), HttpStatus.OK);
    }
    @PostMapping(path = "/agregarReserva",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity agregarReserva(@RequestBody ReservaDTO reservaDTO) {
        try {
            return new ResponseEntity(reservaService.agregarReserva(reservaDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MessageVuelo.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/obtenerReserva/{idReserva}")
    public ResponseEntity<ReservaDTO> obtenerReserva(@PathVariable("idReserva") Integer idReserva) {
        try {
            return new ResponseEntity(reservaService.obtenerReserva(idReserva), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MessageVuelo.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}
