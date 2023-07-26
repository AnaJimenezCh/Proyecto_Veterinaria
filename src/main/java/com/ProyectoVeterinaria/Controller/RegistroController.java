
package com.ProyectoVeterinaria.Controller;

import com.ProyectoVeterinaria.domain.Registro;
import com.ProyectoVeterinaria.service.RegistroService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AnaJimenezCh
 */
@Controller
public class RegistroController {
    
   @RequestMapping("/acerca")
    public String page(Model model) {
        //model.addAttribute("mensaje", "hola desde el controllador");
        return "registro";
    
   
        
        
    }
    
}