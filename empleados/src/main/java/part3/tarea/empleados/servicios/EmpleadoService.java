package part3.tarea.empleados.servicios;


import java.util.List;

import part3.tarea.empleados.modelos.Empleado;

public interface EmpleadoService {
    
    public Empleado guardarEmpleado(Empleado empleado);

    public String eliminarEmpleado(String dni);

    public List<Empleado> obtenerEmpleados();

}
