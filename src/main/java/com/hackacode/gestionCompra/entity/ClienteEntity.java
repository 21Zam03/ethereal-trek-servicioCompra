package com.hackacode.gestionCompra.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "clientes")
public class ClienteEntity extends Persona {
}
