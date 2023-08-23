/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoVeterinaria.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author AnaJimenezCh
 */


@Data
@Entity
@Table(name="farmacia")
public class Farmacia implements Serializable{

    private static final long serialVersionUID = 1L;
    
     @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_farmacia")
    private Long idFarmacia;
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;

    public Farmacia() {
    }

    public Farmacia(Long idFarmacia, String descripcion, String detalle, double precio, int existencias, String rutaImagen, boolean activo) {
        this.idFarmacia = idFarmacia;
        this.descripcion = descripcion;
        this.detalle = detalle;
        this.precio = precio;
        this.existencias = existencias;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }

 
}
