package part4.tarea.energia.servicios.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import part4.tarea.energia.modelos.Abonado;
import part4.tarea.energia.modelos.Facturacion;
import part4.tarea.energia.modelos.TiposResidencia;
import part4.tarea.energia.repositorios.AbonadoRepository;
import part4.tarea.energia.repositorios.TiposResidenciaRepository;
import part4.tarea.energia.servicios.AbonadoService;

@Service
public class AbonadoServiceImpl implements AbonadoService{

    @Autowired
    private TiposResidenciaRepository tiposResidenciaRepository;

    @Autowired
    private AbonadoRepository abonadoRepository;

    @Override
    public Abonado guardarAbonado(Abonado abonado) {
        if(abonado.getTipoResidencia() != null){
            int idtiporesidencia = abonado.getTipoResidencia().getIdtiporesidencia();
            TiposResidencia tiposResidencia = this.tiposResidenciaRepository.findById(idtiporesidencia).get();
            abonado.setTipoResidencia(tiposResidencia);
        }
        if(abonado.getFacturacion() != null){
            for (Facturacion factura : abonado.getFacturacion()) {
                factura.setDni(abonado);
            }
        }
        return this.abonadoRepository.save(abonado);
    }

    @Override
    public Abonado obtenerAbonado(String dni) {
        return this.abonadoRepository.findById(dni).get();
    }

    @Override
    public String eliminarAbonado(String dni) {
        Abonado abonado = this.abonadoRepository.findById(dni).get();

        if(abonado != null) {
            this.abonadoRepository.delete(abonado);
                return "Abonado eliminado con exito";
        }
        return "Abonado no encontrado";
    }
    
}
