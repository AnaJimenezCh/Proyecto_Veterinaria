/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ProyectoVeterinaria.dao;

import com.ProyectoVeterinaria.domain.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author AnaJimenezCh
 */



public interface PacienteDao extends JpaRepository<Paciente, Long> {
    
}