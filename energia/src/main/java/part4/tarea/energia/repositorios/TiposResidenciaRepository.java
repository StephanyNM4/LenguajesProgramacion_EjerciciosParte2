package part4.tarea.energia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import part4.tarea.energia.modelos.TiposResidencia;

public interface TiposResidenciaRepository extends JpaRepository<TiposResidencia, Integer>{
    
}
