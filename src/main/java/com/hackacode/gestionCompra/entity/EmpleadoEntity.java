package com.hackacode.gestionCompra.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "empleado")
public class EmpleadoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "dni")
    private String dni;

    @Column(name = "fecha_nac")
    private Date fechaNac;

    @Column(name = "nacionalidad")
    private String nacionalidad;

    @Column(name = "celular")
    private String celular;

    @Column(name = "correo")
    private String correo;

    //@Enumerated(EnumType.STRING)
    @Column(name = "cargo")
    private String cargo;

    @Column(name = "sueldo")
    private Double sueldo;

    @Column(name = "contrasena")
    private String contrasena;

}
