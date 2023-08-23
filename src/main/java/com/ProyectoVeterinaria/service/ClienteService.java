
package com.ProyectoVeterinaria.service;

import com.ProyectoVeterinaria.domain.Cliente;
import java.util.List;


public interface ClienteService {
 
   
    public List<Cliente> getClientes(boolean activos);
     
    public Cliente getCliente(Cliente cliente );
    
    public void save(Cliente cliente);
    
    
    public void delete(Cliente cliente);
      
 public List<Cliente> getPorNombre(String Nombre);
}
