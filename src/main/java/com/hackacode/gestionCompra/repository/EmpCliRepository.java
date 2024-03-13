package com.hackacode.gestionCompra.repository;

import com.hackacode.gestionCompra.entity.ClienteEntity;
import com.hackacode.gestionCompra.entity.EmpleadoEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "gestionEmpCli")
public interface EmpCliRepository {

    @GetMapping("clientes/{param}")
    public ClienteEntity obtenerCliente(@PathVariable String param);

    @GetMapping("clientes")
    public List<ClienteEntity> listarClientes();

    @GetMapping("empleados/{param}")
    public EmpleadoEntity obtenerEmpleado(@PathVariable String param);

    @GetMapping("empleados")
    public List<EmpleadoEntity> listarEmpleados();

}
