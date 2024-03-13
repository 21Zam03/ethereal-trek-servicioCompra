package com.hackacode.gestionCompra.repository;

import com.hackacode.gestionCompra.entity.ServicioEntity;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "ServicioPaqSer")
public interface ServicioRepository {

    public ServicioEntity crearServicio(ServicioEntity servicio);
    public ServicioEntity obtenerServicio(Integer idServicio);
    public List<ServicioEntity> listarServicios();
    public ServicioEntity actualizarServicio(ServicioEntity servicio);
    public void eliminarServicio(ServicioEntity servicio);

}
