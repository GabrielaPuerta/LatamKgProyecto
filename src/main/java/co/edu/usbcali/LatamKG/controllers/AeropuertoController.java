package co.edu.usbcali.LatamKG.controllers;

import co.edu.usbcali.LatamKG.dto.AeropuertoDTO;
import co.edu.usbcali.LatamKG.dto.MessageVuelo;
import co.edu.usbcali.LatamKG.service.AeropuertoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/aeropuerto")
@Slf4j
public class AeropuertoController {
    private AeropuertoService aeropuertoService;
    public AeropuertoController(AeropuertoService aeropuertoService) {
        this.aeropuertoService = aeropuertoService;
    }
    @GetMapping("/obtenerAeropuerto/{idAeropuerto}")
    public ResponseEntity<AeropuertoDTO> obtenerAeropuerto(@PathVariable("idAeropuerto") Integer idAeropuerto) {
        try {
            return new ResponseEntity(aeropuertoService.obtenerAeropuerto(idAeropuerto), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MessageVuelo.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/obtenerAeropuertos")
    public ResponseEntity<List<AeropuertoDTO>> obtenerAeropuertos()  throws Exception {
        return new ResponseEntity(aeropuertoService.obtenerAeropuertos(), HttpStatus.OK);
    }

    @PostMapping(path = "/agregarAeropuerto",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity agregarAeropuerto(@RequestBody AeropuertoDTO aeropuertoDTO) {
        try {
            return new ResponseEntity(aeropuertoService.agregarAeropuerto(aeropuertoDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MessageVuelo.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}