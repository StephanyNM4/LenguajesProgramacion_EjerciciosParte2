package part4.tarea.energia.servicios.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import part4.tarea.energia.modelos.Abonado;
import part4.tarea.energia.modelos.Facturacion;
import part4.tarea.energia.modelos.TiposResidencia;
import part4.tarea.energia.repositorios.AbonadoRepository;
import part4.tarea.energia.repositorios.FacturacionRepository;
import part4.tarea.energia.repositorios.TiposResidenciaRepository;
import part4.tarea.energia.servicios.FacturacionService;

@Service
public class FacturacionServiceImpl implements FacturacionService{

    @Autowired
    private AbonadoRepository abonadoRepository;

    @Autowired
    private FacturacionRepository facturacionRepository;

    @Autowired
    private TiposResidenciaRepository tiposResidenciarRepository;

    // Terminado
    @Override
    public String crearFacturacion(String dni, Double kwConsumido) {
        Abonado abonado = this.abonadoRepository.findById(dni).get();
        Date fechaActual = new Date(0, 0, 0);
        if (abonado != null) {
            Facturacion facturacion = new Facturacion();
            int idTipoResidencia = abonado.getTipoResidencia().getIdtiporesidencia();
            TiposResidencia tiposResidencia = this.tiposResidenciarRepository.findById(idTipoResidencia).get();
            
            Double precioKw = tiposResidencia.getPreciokw();
            Double totalFacturacion = precioKw * kwConsumido;

            facturacion.setFechaFacturacion(fechaActual);
            facturacion.setDni(abonado);
            facturacion.setKwsConsumidos(kwConsumido);
            facturacion.setTotalFacturacion(totalFacturacion);
            this.facturacionRepository.save(facturacion);
            return "Facturacion guardada";
        }
        return "Abonado no existe";
    }
    
}
