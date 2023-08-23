
package com.ProyectoVeterinaria.service;


import com.ProyectoVeterinaria.domain.Farmacia;
import java.util.List;


public interface FarmaciaService {

   // Se obtiene un listado de farmacias en un List
    public List<Farmacia> getFarmacias(boolean activos);
    
   // Se obtiene un Farmacia, a partir del id de un farmacia
    public Farmacia getFarmacia(Farmacia farmacia);
    
    // Se inserta un nuevo farmacia si el id del farmacia esta vacío
    // Se actualiza un farmacia si el id del farmacia NO esta vacío
    public void save(Farmacia farmacia);
    
    // Se elimina el farmacia que tiene el id pasado por parámetro
    public void delete(Farmacia farmacia);
      // Lista de farmacias con precio entre ordendados por descripción ConsultaAmpliada

            
}