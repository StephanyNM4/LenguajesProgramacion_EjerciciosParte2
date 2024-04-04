package part4.tarea.energia.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import part4.tarea.energia.modelos.Abonado;
import part4.tarea.energia.modelos.Facturacion;
import part4.tarea.energia.modelos.TiposResidencia;
import part4.tarea.energia.servicios.impl.AbonadoServiceImpl;

@RestController
@RequestMapping("/api/abonado")
public class AbonadoController {

    @Autowired
    private AbonadoServiceImpl abonadoServiceImpl;
    
    @GetMapping("/prueba")
    public String prueba(){
        return "Funciona";
    }

    // Terminado
    @PostMapping("/guardar")
    public Abonado guardarAbonado(@RequestBody Abonado abonado) {
        return this.abonadoServiceImpl.guardarAbonado(abonado);
    }

    // Terminado
    @GetMapping("/obtener")
    public Abonado obtenerAbonado(@RequestParam(name = "dni") String dni) {
        return this.abonadoServiceImpl.obtenerAbonado(dni);
    }

    @DeleteMapping("/eliminar")
    public String eliminarAbonado(@RequestParam(name = "dni") String dni) {
        return this.abonadoServiceImpl.eliminarAbonado(dni);
    }
}
