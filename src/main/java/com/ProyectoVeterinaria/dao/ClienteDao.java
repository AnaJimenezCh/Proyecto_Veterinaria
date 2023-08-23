
package com.ProyectoVeterinaria.dao;


import com.ProyectoVeterinaria.domain.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteDao extends JpaRepository<Cliente, Long> {

    public List<Cliente> findByNombre(String Nombre);
    
}