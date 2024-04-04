package part4.tarea.energia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import part4.tarea.energia.modelos.Facturacion;

public interface FacturacionRepository extends JpaRepository<Facturacion, Integer>{
    
}
