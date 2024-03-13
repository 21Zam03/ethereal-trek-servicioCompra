package com.hackacode.gestionCompra.repository;

import com.hackacode.gestionCompra.entity.PaqueteEntity;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "servicioPaqSer")
public interface PaqueteRepository {

    public PaqueteEntity crearPaquete(PaqueteEntity paquete);
    public PaqueteEntity obtenerPaquete(Integer idPaquete);
    public List<PaqueteEntity> listarPaquetes();
    public PaqueteEntity actualizarPaquete(PaqueteEntity paquete);
    public void eliminarPaquete(PaqueteEntity paquete);

}
