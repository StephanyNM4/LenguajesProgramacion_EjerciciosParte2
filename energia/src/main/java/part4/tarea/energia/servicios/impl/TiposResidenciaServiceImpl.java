package part4.tarea.energia.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import part4.tarea.energia.modelos.TiposResidencia;
import part4.tarea.energia.repositorios.TiposResidenciaRepository;
import part4.tarea.energia.servicios.TiposResidenciaService;

@Service
public class TiposResidenciaServiceImpl implements TiposResidenciaService{

    @Autowired
    private TiposResidenciaRepository tiposResidenciaRepository;

    @Override
    public TiposResidencia guardarResidencia(TiposResidencia tiposResidencia) {
        return this.tiposResidenciaRepository.save(tiposResidencia);
    }
    
}
