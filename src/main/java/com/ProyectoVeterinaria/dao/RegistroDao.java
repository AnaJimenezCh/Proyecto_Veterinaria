
package com.ProyectoVeterinaria.dao;

import com.ProyectoVeterinaria.domain.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AnaJimenezCh
 */
public interface RegistroDao extends JpaRepository<Registro, Long>{
    
}
