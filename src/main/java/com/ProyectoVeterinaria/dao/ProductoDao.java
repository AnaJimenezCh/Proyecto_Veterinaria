
package com.ProyectoVeterinaria.dao;

import com.ProyectoVeterinaria.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AnaJimenezCh
 */
public interface ProductoDao extends JpaRepository<Producto, Long>{
   //Ejemplo de método utilizando Métodos de Query
public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup); 
}
