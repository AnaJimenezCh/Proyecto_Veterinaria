/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoTienda.demo.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import lombok.Data;

/**
 *
 * @author Eduardo
 */
@Entity
@Data
@Table(name="usuario")
public class Usuario implements Serializable{
    private static final long serialVersionUID = 1L;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "id_usuario")
 private Long idUsuario;
 private
 private
 private
 private
 private          
         
         
    
 
}