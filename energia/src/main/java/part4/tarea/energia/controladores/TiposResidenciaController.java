package part4.tarea.energia.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import part4.tarea.energia.modelos.TiposResidencia;
import part4.tarea.energia.servicios.impl.TiposResidenciaServiceImpl;

@RestController
@RequestMapping("/api/tiposresidencia")
public class TiposResidenciaController {
    
    @Autowired
    private TiposResidenciaServiceImpl tiposResidenciaServiceImpl;

    @GetMapping("/prueba")
    public String prueba(){
        return "Funciona";
    }

    // Terminado
    @PostMapping("/guardar")
    public TiposResidencia guardarResidencia(@RequestBody TiposResidencia tiposResidencia) {
        return this.tiposResidenciaServiceImpl.guardarResidencia(tiposResidencia);
    }
}
