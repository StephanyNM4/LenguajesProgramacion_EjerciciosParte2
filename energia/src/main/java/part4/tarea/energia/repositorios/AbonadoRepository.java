package part4.tarea.energia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import part4.tarea.energia.modelos.Abonado;

public interface AbonadoRepository extends JpaRepository<Abonado, String>{
    
}
