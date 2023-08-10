
package com.ProyectoVeterinaria.service;

import com.ProyectoVeterinaria.domain.Registro;
import java.util.List;

/**
 *
 * @author AnaJimenezCh
 */
public interface RegistroService {
  public List <Registro> getRegistros(boolean activos);
  
}
