
package com.ProyectoVeterinaria.service;

import com.ProyectoVeterinaria.domain.Paciente;
import java.util.List;



/**
 *
 * @author AnaJimenezCh
 */
public interface PacienteService {
   
    public List<Paciente> getPacientes(boolean activos);
     // Se obtiene un Producto, a partir del id de un producto
    public Paciente getPaciente(Paciente paciente);
    
    // Se inserta un nuevo producto si el id del producto esta vacío
    // Se actualiza un producto si el id del producto NO esta vacío
    public void save(Paciente paciente);
    
    // Se elimina el producto que tiene el id pasado por parámetro
    public void delete(Paciente paciente);
      // Lista de productos con precio entre ordendados por descripción ConsultaAmpliada
}
