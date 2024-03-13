package com.hackacode.gestionCompra.service.impl;

import com.hackacode.gestionCompra.dto.VentaDTO;
import com.hackacode.gestionCompra.entity.*;
import com.hackacode.gestionCompra.repository.*;
import com.hackacode.gestionCompra.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaServiceImpl implements VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private ServicioRepository servicioRepository;

    @Autowired
    private PaqueteRepository paqueteRepository;

    @Override
    public VentaEntity crearVenta(VentaDTO ventaDTO) {
        VentaEntity ventaEntity = new VentaEntity();
        ClienteEntity cliente = new ClienteEntity();
        cliente.setIdCliente(ventaDTO.getIdCliente());
        ventaEntity.setCliente(cliente);

        EmpleadoEntity empleado = new EmpleadoEntity();
        empleado.setIdEmpleado(ventaDTO.getIdEmpleado());
        ventaEntity.setEmpleado(empleado);

        if (ventaDTO.getIdServicio() == null) {
            PaqueteEntity paquete = new PaqueteEntity();
            paquete.setIdPaquete(ventaDTO.getIdPaquete());
            ventaEntity.setPaquete(paquete);
        } else {
            ServicioEntity servicio = new ServicioEntity();
            servicio.setIdServicio(ventaDTO.getIdServicio());
            ventaEntity.setServicio(servicio);
        }

        ventaEntity.setTipoVenta(ventaDTO.getTipo_venta());
        ventaEntity.setFechaVenta(ventaDTO.getFecha_venta());
        ventaEntity.setMedioPago(ventaDTO.getMedio_pago());
        return ventaRepository.save(ventaEntity);

    }

    @Override
    public VentaEntity obtenerVenta(Integer idVenta) {
        return ventaRepository.findById(idVenta).get();
    }

    @Override
    public List<VentaEntity> listarVentas() {
        return ventaRepository.findAll();
    }

    @Override
    public VentaEntity actualizarVenta(VentaEntity venta) {
        return ventaRepository.save(venta);
    }

    @Override
    public void eliminarVenta(VentaEntity venta) {
        ventaRepository.delete(venta);
    }

}
