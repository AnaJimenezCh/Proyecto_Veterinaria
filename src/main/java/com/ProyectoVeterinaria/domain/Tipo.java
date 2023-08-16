
package com.ProyectoVeterinaria.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="tipo")
public class Tipo implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="id_tipo")
    private Long idTipo;
    private String descripcion;
    private String rutaImagen;
    private boolean activo;

    public Tipo() {
    }

    public Tipo(String descripcion, String rutaImagen, boolean activo) {
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.activo = activo;
    }


      
    

    
    
    
}
