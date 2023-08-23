package com.ProyectoVeterinaria.Controller;

import com.ProyectoVeterinaria.domain.Cliente;
import com.ProyectoVeterinaria.domain.Paciente;
import com.ProyectoVeterinaria.service.ClienteService;
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
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @GetMapping("/lista")
    public String page(Model model) {
        log.info("Consumiendo el recurso /cliente/lista");
         List<Cliente> clientes = clienteService.getClientes(false);
        
        model.addAttribute("totalClientes", clientes.size());
        model.addAttribute("clientes", clientes);
        
     
        return "/cliente/lista";
    }

    @GetMapping("/nuevo")
    public String clienteNuevo(Cliente cliente) {
        return "/cliente/modifica";
    }

    @PostMapping("/guardar")
    public String clienteGuardar(Cliente cliente) {
      clienteService.save(cliente);
        return "redirect:/cliente/lista";
    }

    @GetMapping("/eliminar/{idCliente}")
    public String clienteEliminar(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/lista";
    }

    @GetMapping("/modificar/{idCliente}")
    public String clienteModificar(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente); 
        return "/cliente/modifica";
    }

}
