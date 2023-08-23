
package com.ProyectoVeterinaria.Controller;

import com.ProyectoVeterinaria.domain.Cliente;
import com.ProyectoVeterinaria.domain.Paciente;
import com.ProyectoVeterinaria.service.ClienteService;

import com.ProyectoVeterinaria.service.PacienteService;

import com.ProyectoVeterinaria.service.impl.FirebaseStorageServiceImpl;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/paciente")
public class PacienteController {
    
    @Autowired
    PacienteService pacienteService;
    
    @Autowired
    ClienteService clienteService;
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    
    @GetMapping("/lista")
    public String page(Model model) {
        log.info("Consumiendo el recurso /paciente/lista");
        List<Paciente> pacientes = pacienteService.getPacientes(false);
        List<Cliente> clientes = clienteService.getClientes(true);
             model.addAttribute("totalPacientes", pacientes.size());
        model.addAttribute("pacientes", pacientes);
        model.addAttribute("clientes", clientes);
       return "/paciente/lista";
    }
@GetMapping("/nuevo")
    public String pacienteNuevo(Paciente paciente) {
        return "/paciente/modifica";
    }

    
    @PostMapping("/guardar")
    public String pacienteGuardar(Paciente paciente,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            pacienteService.save(paciente);
            paciente.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "paciente", 
                            paciente.getIdPaciente()));
        }
        pacienteService.save(paciente);
        return "redirect:/paciente/lista";
    }

    @GetMapping("/eliminar/{idPaciente}")
    public String pacienteEliminar(Paciente paciente) {
        pacienteService.delete(paciente);
        return "redirect:/paciente/lista";
    }

    @GetMapping("/modificar/{idPaciente}")
    public String pacienteModificar(Paciente paciente, Model model) {
        paciente = pacienteService.getPaciente(paciente);
         List<Cliente> clientes = clienteService.getClientes(true);
        model.addAttribute("paciente", paciente);
        model.addAttribute("clientes", clientes);
        return "/paciente/modifica";
    }

}
