/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ProyectoVeterinaria.domain;

/**
 *
 * @author AnaJimenezCh
 */
import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="paciente")
public class Paciente implements Serializable{

    private static final long serialVersionUID = 1L;
    
     @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_paciente")
    private Long idPaciente;
    private String nombre;
    private String identificacion;
    private String consulta;
    private String rutaImagen;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id_tipo")
    private Tipo tipo;

    public Paciente() {
    }

    public Paciente(Long idPaciente, String nombre, String identificacion, String consulta, String rutaImagen, boolean activo, Tipo tipo) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.consulta = consulta;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
        this.tipo = tipo;
    }

 
    }

 
   

    
   

    

  
   