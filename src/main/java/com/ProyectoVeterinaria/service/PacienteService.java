
package com.ProyectoVeterinaria.service;

import com.ProyectoVeterinaria.domain.Paciente;
import java.util.List;



/**
 *
 * @author AnaJimenezCh
 */
public interface PacienteService {
   
    public List<Paciente> getPacientes(boolean activos);
     
    public Paciente getPaciente(Paciente paciente);
    
    public void save(Paciente paciente);
    
    
    public void delete(Paciente paciente);
    
     public List<Paciente> getPorMascota(String Mascota);
}
