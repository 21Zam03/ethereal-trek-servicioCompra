package com.hackacode.gestionCompra.controller;

import com.hackacode.gestionCompra.dto.VentaDTO;
import com.hackacode.gestionCompra.entity.VentaEntity;
import com.hackacode.gestionCompra.service.VentaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/ventas")
@Slf4j
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @PostMapping
    public ResponseEntity<VentaEntity> crearVenta(@RequestBody VentaDTO ventaDTO) {
        if (ventaDTO == null) {
            log.info("La venta es nula");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            log.info("Venta Creada");
            return new ResponseEntity<>(ventaService.crearVenta(ventaDTO), HttpStatus.CREATED);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            log.info("Error!!! Venta no creada");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<VentaEntity> obtenerVenta(@PathVariable(value = "id") Integer idVenta) {
        if (idVenta == null || idVenta <= 0) {
            log.info("El id venta es nulo, menor e igual a 0");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            VentaEntity ventaEntity = ventaService.obtenerVenta(idVenta);
            if (ventaEntity != null) {
                log.info("Venta obtenida");
                return new ResponseEntity<>(ventaEntity, HttpStatus.OK);
            } else {
                log.info("Error!!! Venta no encontrado en la base de datos");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            log.info("Error!!! Venta no obtenida");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<VentaEntity>> listarVentas() {
        List<VentaEntity> listaVentas = ventaService.listarVentas();
        try {
            log.info("Lista de ventas obtenidas");
            return new ResponseEntity<>(listaVentas, HttpStatus.OK);
        } catch (Exception e) {
            log.info("Error interno en el servidor");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<VentaEntity> actualizarVenta(@RequestBody VentaEntity ventaEntity) {
        if (ventaEntity.getIdVenta() == null || ventaEntity.getIdVenta() <= 0) {
            log.info("El id venta es nulo, menor e igual a 0");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            VentaEntity venta = ventaService.obtenerVenta(ventaEntity.getIdVenta());
            if (venta != null) {
                log.info("Venta actualizada");
                return new ResponseEntity<>(ventaService.actualizarVenta(ventaEntity), HttpStatus.OK);
            } else {
                log.info("Error!!! venta a actualizar no existe en la base de datos");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.info("Error interno en el servidor");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarVenta(@PathVariable(value = "id") Integer idVenta) {
        if (idVenta == null || idVenta <= 0) {
            log.info("El id venta es nulo, menor e igual a 0");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            VentaEntity ventaEntity = ventaService.obtenerVenta(idVenta);
            if (ventaEntity != null) {
                log.info("Venta eliminada");
                ventaService.eliminarVenta(ventaEntity);
                return new ResponseEntity<>("Venta Eliminada", HttpStatus.OK);
            } else {
                log.info("Error!!! Venta a eliminar no existe en la base de datos");
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            log.info("Error interno en el servidor");
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
