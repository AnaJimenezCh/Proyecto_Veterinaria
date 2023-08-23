
package com.ProyectoVeterinaria.service.impl;

import com.ProyectoVeterinaria.dao.PacienteDao;
import com.ProyectoVeterinaria.domain.Paciente;
import com.ProyectoVeterinaria.service.PacienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author AnaJimenezCh
 */
@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteDao pacienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Paciente> getPacientes(boolean activos) {
        List<Paciente> lista = pacienteDao.findAll();

        if (activos) {
            // para remover las Productos donde estan activos
            lista.removeIf(x -> !x.isActivo());
        }

        return lista;
    
    }
   @Override
    @Transactional(readOnly = true)
    public Paciente getPaciente(Paciente paciente) {
        return pacienteDao.findById(paciente.getIdPaciente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Paciente paciente) {
        pacienteDao.save(paciente);
    }

    @Override
    @Transactional
    public void delete(Paciente paciente) {
        pacienteDao.delete(paciente);
    } 

    @Override
    public List<Paciente> getPorMascota(String Mascota) {
 return pacienteDao.findByMascota(Mascota)      ; 
    }

    
    }

               
