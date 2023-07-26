
package com.ProyectoVeterinaria.service.impl;

import com.ProyectoVeterinaria.dao.RegistroDao;
import com.ProyectoVeterinaria.domain.Registro;
import com.ProyectoVeterinaria.service.RegistroService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


 
@Service
 public class RegistroServiceImpl implements RegistroService {

    @Autowired
    private RegistroDao registroDao;

    @Override
    @Transactional(readOnly = true)
    public List<Registro> getRegistros(boolean activos){
        List<Registro> lista = registroDao.findAll();

        if (activos){
            // para remover las Categorias donde estan activos
            lista.removeIf(x -> !x.isActivo());
        }

        return lista;
    
    } }


