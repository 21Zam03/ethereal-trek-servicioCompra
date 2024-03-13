package com.hackacode.gestionCompra.service;

import com.hackacode.gestionCompra.dto.VentaDTO;
import com.hackacode.gestionCompra.entity.VentaEntity;

import java.util.List;

public interface VentaService {

    public VentaEntity crearVenta(VentaDTO ventaDTO);
    public VentaEntity obtenerVenta(Integer idVenta);
    public List<VentaEntity> listarVentas();
    public VentaEntity actualizarVenta(VentaEntity venta);
    public void eliminarVenta(VentaEntity venta);

}
