
package com.ProyectoVeterinaria.service.impl;


import com.ProyectoVeterinaria.dao.FarmaciaDao;
import com.ProyectoVeterinaria.domain.Farmacia;
import com.ProyectoVeterinaria.service.FarmaciaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author AnaJimenezCh
 */
@Service
public class FarmaciaServiceImpl implements FarmaciaService {

    @Autowired
    private FarmaciaDao farmaciaDao;

    @Override
    @Transactional(readOnly = true)
    public List<Farmacia> getFarmacias(boolean activos) {
        List<Farmacia> lista = farmaciaDao.findAll();

        if (activos) {
            // para remover las Productos donde estan activos
            lista.removeIf(x -> !x.isActivo());
        }

        return lista;
    
    }
   @Override
    @Transactional(readOnly = true)
    public Farmacia getFarmacia(Farmacia farmacia) {
        return farmaciaDao.findById(farmacia.getIdFarmacia()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Farmacia farmacia) {
        farmaciaDao.save(farmacia);
    }

    @Override
    @Transactional
    public void delete(Farmacia farmacia) {
        farmaciaDao.delete(farmacia);
    } 

     
    

    
    }