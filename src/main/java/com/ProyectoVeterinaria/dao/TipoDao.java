
package com.ProyectoVeterinaria.dao;

import com.ProyectoVeterinaria.domain.Tipo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 
 * @author AnaJimenezCh
 */
public interface TipoDao extends JpaRepository<Tipo, Long> {

    public List<Tipo> findByDescripcion(String descripcion);
    
}
