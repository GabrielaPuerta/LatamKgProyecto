package co.edu.usbcali.LatamKG.controllers;

import co.edu.usbcali.LatamKG.dto.AsientoDTO;
import co.edu.usbcali.LatamKG.dto.MessageVuelo;
import co.edu.usbcali.LatamKG.service.AsientoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/asiento")
@Slf4j
public class AsientoController {
    private final AsientoService asientoService;
    public AsientoController(AsientoService asientoService) {
        this.asientoService = asientoService;
    }
    @GetMapping("/obtenerAsientos")
    public ResponseEntity<List<AsientoDTO>> obtenerAsientos() {
        return new ResponseEntity(asientoService.obtenerAsientos(), HttpStatus.OK);
    }
    @GetMapping("/obtenerAsiento/{idAsiento}")
    public ResponseEntity<AsientoDTO> obtenerAsiento(@PathVariable("idAsiento") Integer idAsiento) {
        try {
            return new ResponseEntity(asientoService.obtenerAsiento(idAsiento), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MessageVuelo.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping(path = "/agregarAsiento",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarAsiento(@RequestBody AsientoDTO asientoDTO) {
        try {
            return new ResponseEntity(asientoService.agregarAsiento(asientoDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MessageVuelo.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}