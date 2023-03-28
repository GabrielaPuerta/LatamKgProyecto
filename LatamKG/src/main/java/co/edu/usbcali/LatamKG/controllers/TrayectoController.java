package co.edu.usbcali.LatamKG.controllers;

import co.edu.usbcali.LatamKG.dto.MessageVuelo;
import co.edu.usbcali.LatamKG.dto.TrayectoDTO;
import co.edu.usbcali.LatamKG.service.TrayectoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trayecto")
@Slf4j
public class TrayectoController {
    private final TrayectoService trayectoService;
    public TrayectoController(TrayectoService trayectoService) {
        this.trayectoService = trayectoService;
    }
    @GetMapping("/obtenerTrayecto/{idTrayecto}")
    public ResponseEntity<TrayectoDTO> obtenerTrayecto(@PathVariable("idTrayecto") Integer idTrayecto) {
        try {
            return new ResponseEntity(trayectoService.obtenerTrayecto(idTrayecto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MessageVuelo.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(path = "/agregarTrayecto",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarTrayecto(@RequestBody TrayectoDTO trayectoDTO) {
        try {
            return new ResponseEntity(trayectoService.agregarTrayecto(trayectoDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MessageVuelo.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/obtenerTrayectos")
    public ResponseEntity<List<TrayectoDTO>> obtenerTrayectos() {
        return new ResponseEntity(trayectoService.obtenerTrayectos(), HttpStatus.OK);
    }
}
