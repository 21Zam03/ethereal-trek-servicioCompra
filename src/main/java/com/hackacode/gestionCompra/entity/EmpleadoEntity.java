package com.hackacode.gestionCompra.entity;

import com.hackacode.gestionCompra.enums.Cargo;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "empleados")
public class EmpleadoEntity extends Persona{

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @Column(nullable = false)
    private Double sueldo;

}
