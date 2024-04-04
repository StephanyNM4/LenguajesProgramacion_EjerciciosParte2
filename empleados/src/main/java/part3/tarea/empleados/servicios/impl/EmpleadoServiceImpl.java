package part3.tarea.empleados.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import part3.tarea.empleados.modelos.Empleado;
import part3.tarea.empleados.modelos.HistoricoPago;
import part3.tarea.empleados.repositorios.EmpleadoRepository;
import part3.tarea.empleados.repositorios.HistoricoPagoRepository;
import part3.tarea.empleados.servicios.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return this.empleadoRepository.save(empleado);
    }

    @Override
    public String eliminarEmpleado(String dni) {
        Empleado empleado = this.empleadoRepository.findById(dni).get();

        if (empleado != null) {
            this.empleadoRepository.delete(empleado);
            return "Empleado eliminado";
        }
        return "Empleado no existe";
    }

    @Override
    public List<Empleado> obtenerEmpleados() {
        return this.empleadoRepository.findAll();
    }
    
}
