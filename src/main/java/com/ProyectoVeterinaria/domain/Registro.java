
package com.ProyectoVeterinaria.domain;

import jakarta.persistence.*;
import java.io.Serializable;


/**
 *
 * @author AnaJimenezCh
 */
@Entity
@Table(name="registro")
public class Registro implements Serializable{
     private static final long serialVersionUID= 1L;
    
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Long idCliente; //se transforma en id_categoria
    private String nombre;
    private String raza;
    private String descripcion;
    private boolean activo;

    public Registro() {
    }

    public Registro( String nombre, String raza, String descripcion, boolean activo) {
       
        this.nombre = nombre;
        this.raza = raza;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    public boolean isActivo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

   
   
   
}
       

   
    

    
