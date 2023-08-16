
package com.ProyectoVeterinaria.service.impl;



import com.ProyectoVeterinaria.dao.TipoDao;
import com.ProyectoVeterinaria.domain.Tipo;
import com.ProyectoVeterinaria.service.TipoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
public class TipoServiceImpl implements TipoService{
   
    @Autowired
   private TipoDao tipoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Tipo> getTipos(boolean activos){
    List<Tipo> lista = tipoDao.findAll();
    
   if (activos){
       lista.removeIf(x -> !x.isActivo());
   }
    return lista;
    }
     @Override
    @Transactional(readOnly = true)
    public Tipo getTipo(Tipo tipo) {
        return tipoDao.findById(tipo.getIdTipo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Tipo tipo) {
       tipoDao.save(tipo);
    }

    @Override
    @Transactional
    public void delete(Tipo tipo) {
        tipoDao.delete(tipo);
    }    

    @Override
    public List<Tipo> getPorDescripcion(String descripcion) {
        return tipoDao.findByDescripcion(descripcion);
    }
}


