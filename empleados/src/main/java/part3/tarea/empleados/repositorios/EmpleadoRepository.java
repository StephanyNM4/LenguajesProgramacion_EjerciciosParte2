package part3.tarea.empleados.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import part3.tarea.empleados.modelos.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, String>{
    
}
