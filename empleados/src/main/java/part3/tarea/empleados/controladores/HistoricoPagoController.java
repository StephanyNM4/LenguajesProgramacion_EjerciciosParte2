package part3.tarea.empleados.controladores;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import part3.tarea.empleados.modelos.Empleado;
import part3.tarea.empleados.modelos.HistoricoPago;
import part3.tarea.empleados.servicios.impl.EmpleadoServiceImpl;
import part3.tarea.empleados.servicios.impl.HistoricoPagoServiceImpl;

@RestController
@RequestMapping("/api/pagos")
public class HistoricoPagoController {
    
    @Autowired
    private HistoricoPagoServiceImpl historicoPagoServiceImpl;

    @GetMapping("/prueba")
    public String prueba(){
        return "Funciona";
    }

    @GetMapping("/buscar")
    public List<HistoricoPago> buscar(@RequestParam(value = "dni") String dni) {
        return this.historicoPagoServiceImpl.buscar(dni);
    }

    @GetMapping("/fecha/{dni}")
    public List<HistoricoPago> obtenerPagosPorFecha(@PathVariable(value = "dni") String dni,@RequestParam(value = "fechaInicio") Date fechaInicio,@RequestParam(value = "fechaFin") Date fechaFin) {
        return this.historicoPagoServiceImpl.obtenerPagosPorFecha(dni, fechaInicio, fechaFin);
    }

    @PostMapping("/guardar/{dni}")
    public String guardarPago(@PathVariable(value = "dni") String dni, @RequestParam(value = "horasTrabajadas") int horasTrabajadas,@RequestParam(value = "precioHora") Double precioHora) {
            return this.historicoPagoServiceImpl.guardarPago(dni, horasTrabajadas, precioHora);
    }
}
