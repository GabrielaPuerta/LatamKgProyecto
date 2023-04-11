package co.edu.usbcali.LatamKG.controllers;

import co.edu.usbcali.LatamKG.dto.FacturaDTO;
import co.edu.usbcali.LatamKG.dto.MessageVuelo;
import co.edu.usbcali.LatamKG.service.FacturaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factura")
@Slf4j
public class FacturaController {
    private final FacturaService facturaService;
    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }
    @GetMapping("/obtenerFacturas")
    public ResponseEntity<List<FacturaDTO>> obtenerFacturas() {
        return new ResponseEntity(facturaService.obtenerFacturas(), HttpStatus.OK);
    }

    @GetMapping("/obtenerFactura/{idFactura}")
    public ResponseEntity<FacturaDTO> obtenerFactura(@PathVariable("idFactura") Integer idFactura) {
        try {
            return new ResponseEntity(facturaService.obtenerFactura(idFactura), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MessageVuelo.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/agregarFactura",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity guardarFactura(@RequestBody FacturaDTO facturaDTO) {
        try {
            return new ResponseEntity(facturaService.agregarFactura(facturaDTO), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(MessageVuelo.builder().mensaje(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
        }
    }
}