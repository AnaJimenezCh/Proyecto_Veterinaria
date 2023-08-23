
package com.ProyectoVeterinaria.Controller;


import com.ProyectoVeterinaria.service.FarmaciaService;
import com.ProyectoVeterinaria.domain.Farmacia;
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
@RequestMapping("/farmacia")
public class FarmaciaController {
    
    @Autowired
    FarmaciaService farmaciaService;
    

    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    
    @GetMapping("/listado")
    public String page(Model model) {
        log.info("Consumiendo el recurso /farmacia/listado");
        List<Farmacia> farmacias = farmaciaService.getFarmacias(false);
      
        
        model.addAttribute("farmacias", farmacias);
      
        model.addAttribute("totalFarmacias", farmacias.size());
        return "/farmacia/listado";
    }
@GetMapping("/nuevo")
    public String farmaciaNuevo(Farmacia farmacia) {
        return "/farmacia/modifica";
    }

    
    @PostMapping("/guardar")
    public String farmaciaGuardar(Farmacia farmacia,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            farmaciaService.save(farmacia);
            farmacia.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "farmacia", 
                            farmacia.getIdFarmacia()));
        }
        farmaciaService.save(farmacia);
        return "redirect:/farmacia/listado";
    }

    @GetMapping("/eliminar/{idFarmacia}")
    public String farmaciaEliminar(Farmacia farmacia) {
        farmaciaService.delete(farmacia);
        return "redirect:/farmacia/listado";
    }

    @GetMapping("/modificar/{idFarmacia}")
    public String farmaciaModificar( Farmacia farmacia, Model model) {
        farmacia = farmaciaService.getFarmacia(farmacia);
        
        model.addAttribute("farmacia", farmacia);
        
        return "/farmacia/modifica";
    }

}