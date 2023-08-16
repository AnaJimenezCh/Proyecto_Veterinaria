
package com.ProyectoVeterinaria.Controller;


/**
 *
 * @author AnaJimenezCh
 */
import com.ProyectoVeterinaria.domain.Tipo;
import com.ProyectoVeterinaria.service.TipoService;
import com.ProyectoVeterinaria.service.impl.FirebaseStorageServiceImpl;
import jakarta.servlet.http.HttpSession;
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
@RequestMapping("/tipo")
public class tipoController {
    
    @Autowired
    TipoService tipoService;
    
      @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
   @GetMapping("/listado")
    public String inicio(Model model, HttpSession session) {
        log.info("Consumienod el recurso /categoria/listado");
        List<Tipo> tipos = tipoService.getTipos(false);
     // String imagen =(String)session.getAttribute("usuarioImagen");
       // model.addAttribute("avatar", "imagen");
        //model.addAttribute("EmailUsuario", (String)session.getAttribute("Email"));
        model.addAttribute("tipos", tipos);
        model.addAttribute("totalTipos", tipos.size());
        return "/tipo/listado";
    }
@GetMapping("/nuevo")
    public String tipoNuevo(Tipo tipo) {
        return "/tipo/modifica";
    }

  
    @PostMapping("/guardar")
    public String tipoGuardar(Tipo tipo,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            tipoService.save(tipo);
            tipo.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "tipo", 
                            tipo.getIdTipo()));
        }
        tipoService.save(tipo);
        return "redirect:/tipo/listado";
    }

    @GetMapping("/eliminar/{idCategoria}")
    public String tipoEliminar(Tipo tipo) {
        tipoService.delete(tipo);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/modificar/{idTipo}")
    public String tipoModificar(Tipo tipo, Model model) {
        tipo = tipoService.getTipo(tipo);
        model.addAttribute("tipo", tipo);
        return "/tipo/modifica";
    }

}