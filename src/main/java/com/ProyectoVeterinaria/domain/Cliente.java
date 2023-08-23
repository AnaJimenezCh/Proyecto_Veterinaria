package com.ProyectoVeterinaria.domain;




import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{

    private static final long serialVersionUID = 1L;
    
     @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Long idCliente;
    private String nombre;
    private String identificacion;
    private String telefono;
    private String correo;
    private double precio;
    private boolean activo;
    
   
   @OneToMany
    @JoinColumn(name="id_cliente") 
  private List<Paciente> pacientes;
   
    public Cliente() {
    }

    public Cliente( String nombre, String identificacion, String telefono, String correo, double precio, boolean activo) {
       
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.telefono = telefono;
        this.correo = correo;
        this.precio = precio;
        this.activo = activo;
      
    }



}
    
 