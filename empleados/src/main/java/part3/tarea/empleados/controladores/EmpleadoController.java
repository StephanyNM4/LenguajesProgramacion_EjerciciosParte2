package part3.tarea.empleados.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import part3.tarea.empleados.modelos.Empleado;
import part3.tarea.empleados.modelos.HistoricoPago;
import part3.tarea.empleados.servicios.impl.EmpleadoServiceImpl;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
    
    @Autowired
    private EmpleadoServiceImpl empleadoServiceImpl;

    @GetMapping("/prueba")
    public String prueba(){
        return "Funciona";
    }

    @PostMapping("/guardar")
    public Empleado guardarEmpleado(@RequestBody Empleado empleado) {
        for (HistoricoPago pagos  : empleado.getHistoricoPago()) {
            pagos.setEmpleado(empleado);
        }
        return this.empleadoServiceImpl.guardarEmpleado(empleado);
    }

    @DeleteMapping("/eliminar")
    public String eliminarEmpleado(@RequestParam String dni) {
        return this.empleadoServiceImpl.eliminarEmpleado(dni);
    }

    @GetMapping("/obtener")
    public List<Empleado> obtenerEmpleados() {
        return this.empleadoServiceImpl.obtenerEmpleados();
    }
}
