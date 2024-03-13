package com.hackacode.gestionCompra.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {

    private Integer idCliente;
    private Integer idEmpleado;
    private Integer idServicio;
    private Integer idPaquete;
    private String tipo_venta;
    private Date fecha_venta;
    private String medio_pago;

}
