package com.hackacode.gestionCompra.repository;

import com.hackacode.gestionCompra.entity.EmpleadoEntity;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "servicioEmplCli")
public interface EmpleadoRepository {

    public EmpleadoEntity crearEmpleado(EmpleadoEntity empleado);
    public EmpleadoEntity obtenerEmpleado(Integer idEmpleado);
    public List<EmpleadoEntity> listarEmpleados();
    public EmpleadoEntity actualizarEmpleado(EmpleadoEntity empleado);
    public void eliminarEmpleado(EmpleadoEntity empleado);

}
