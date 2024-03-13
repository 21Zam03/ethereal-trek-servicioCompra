package com.hackacode.gestionCompra.repository;

import com.hackacode.gestionCompra.entity.PaqueteEntity;
import com.hackacode.gestionCompra.entity.ServicioEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "gestionPaqSer")
public interface PaqSerRepository {

    @GetMapping("api/paquetes/{id}")
    public PaqueteEntity obtenerPaquete(@PathVariable(value = "id") Integer idPaquete);

    @GetMapping("api/paquetes")
    public List<PaqueteEntity> listarPaquetes();

    @GetMapping("api/servicios/{id}")
    public ServicioEntity obtenerServicio(@PathVariable(name = "id") Integer idServicio);

    @GetMapping("api/servicios")
    public List<ServicioEntity> listarServicios();

}
