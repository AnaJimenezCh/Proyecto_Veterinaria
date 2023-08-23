
package com.ProyectoVeterinaria.service.impl;



import com.ProyectoVeterinaria.dao.ProductoDao;
import com.ProyectoVeterinaria.domain.Producto;
import com.ProyectoVeterinaria.service.ProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author AnaJimenezCh
 */
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao productoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        List<Producto> lista = productoDao.findAll();

        if (activos) {
            // para remover las Productos donde estan activos
            lista.removeIf(x -> !x.isActivo());
        }

        return lista;
    
    }
   @Override
    @Transactional(readOnly = true)
    public Producto getProducto(Producto producto) {
        return productoDao.findById(producto.getIdProducto()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Producto producto) {
        productoDao.save(producto);
    }

    @Override
    @Transactional
    public void delete(Producto producto) {
        productoDao.delete(producto);
    } 

  

     
    

    
    }