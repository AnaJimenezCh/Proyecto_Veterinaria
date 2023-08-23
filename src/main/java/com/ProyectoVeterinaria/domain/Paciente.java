
package com.ProyectoVeterinaria.domain;


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
    private String mascota;
    private String consulta;
    private String rutaImagen;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    public Paciente() {
    }

    public Paciente(Long idPaciente, String mascota, String consulta, String rutaImagen, boolean activo, Cliente cliente) {
        this.idPaciente = idPaciente;
        this.mascota = mascota;
        this.consulta = consulta;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
        this.cliente = cliente;
    }

 

   

   

 
    }

   
    

        
    

 
     
    

 
    

 
   

    
   

    

  
   