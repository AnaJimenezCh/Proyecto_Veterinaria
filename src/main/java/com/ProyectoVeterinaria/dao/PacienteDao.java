
package com.ProyectoVeterinaria.dao;

import com.ProyectoVeterinaria.domain.Paciente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteDao extends JpaRepository<Paciente, Long> {

    public List<Paciente> findByMascota(String Mascota);

   
    
}