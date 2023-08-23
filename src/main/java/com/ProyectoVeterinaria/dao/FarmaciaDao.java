
package com.ProyectoVeterinaria.dao;


import com.ProyectoVeterinaria.domain.Farmacia;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AnaJimenezCh
 */
public interface FarmaciaDao extends JpaRepository<Farmacia, Long>{
   //Ejemplo de método utilizando Métodos de Query
public List<Farmacia> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup); 
}