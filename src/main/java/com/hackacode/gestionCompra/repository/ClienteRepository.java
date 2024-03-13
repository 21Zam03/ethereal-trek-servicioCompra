package com.hackacode.gestionCompra.repository;

import com.hackacode.gestionCompra.entity.ClienteEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@FeignClient("servicioEmplCli")
public interface ClienteRepository {

    @PostMapping("/auth/{param}")
    @ResponseStatus(HttpStatus.CREATED)
    public ClienteEntity crearCliente(ClienteEntity cliente);

    @GetMapping("/auth/{param}")
    public ClienteEntity obtenerCliente(Integer idCliente);
    public List<ClienteEntity> listarClientes();
    public ClienteEntity actualizarCliente(ClienteEntity cliente);
    public void eliminarCliente(ClienteEntity cliente);

}
