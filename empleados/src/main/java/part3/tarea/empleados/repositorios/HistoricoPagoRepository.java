package part3.tarea.empleados.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import part3.tarea.empleados.modelos.HistoricoPago;

public interface HistoricoPagoRepository extends JpaRepository<HistoricoPago, Integer>{
    
}
