
package com.ProyectoVeterinaria.service.impl;

import com.ProyectoVeterinaria.dao.ClienteDao;
import com.ProyectoVeterinaria.domain.Cliente;
import com.ProyectoVeterinaria.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author AnaJimenezCh
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes(boolean activos) {
        List<Cliente> lista = clienteDao.findAll();

        if (activos) {
            // para remover las Productos donde estan activos
            lista.removeIf(x -> !x.isActivo());
        }

        return lista;
    
    }
   @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    } 

    @Override
    public List<Cliente> getPorNombre(String Nombre) {
       
        return clienteDao.findByNombre(Nombre);
       
    }

}