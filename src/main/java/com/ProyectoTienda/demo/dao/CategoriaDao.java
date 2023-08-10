/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoTienda.demo.dao;

import com.ProyectoTienda.demo.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Eduardo
 */
public interface CategoriaDao extends JpaRepository<Categoria, Long>{
    // Mas adelatne,vamos a tener metodos amplios
    List<Categoria> findByDescripcion(String descripcion);
}
