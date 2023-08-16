
package com.ProyectoVeterinaria.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author AnaJimenezCh
 */
@Controller
public class indexController {
    
    @RequestMapping("/")
    public String page(Model model) {
        model.addAttribute("attribute", "Hola desde el controllador");
        return "index";
    }
    
}
