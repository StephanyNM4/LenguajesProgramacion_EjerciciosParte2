package part4.tarea.energia.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import part4.tarea.energia.servicios.impl.FacturacionServiceImpl;

@RestController
@RequestMapping("/api/facturacion")
public class FacturacionController {
    
    @Autowired
    private FacturacionServiceImpl facturacionServiceImpl;

    @GetMapping("/prueba")
    public String prueba(){
        return "Funciona";
    }

    // Terminado
    @PostMapping("/guardar")
    public String crearFacturacion(@RequestParam(name = "dni") String dni,@RequestParam(name = "kwConsumido") Double kwConsumido) {
        return this.facturacionServiceImpl.crearFacturacion(dni, kwConsumido);
    }
}
