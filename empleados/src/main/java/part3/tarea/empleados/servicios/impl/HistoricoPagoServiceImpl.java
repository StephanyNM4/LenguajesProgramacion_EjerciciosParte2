package part3.tarea.empleados.servicios.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.websocket.server.PathParam;
import part3.tarea.empleados.modelos.Empleado;
import part3.tarea.empleados.modelos.HistoricoPago;
import part3.tarea.empleados.repositorios.EmpleadoRepository;
import part3.tarea.empleados.repositorios.HistoricoPagoRepository;
import part3.tarea.empleados.servicios.HistoricoPagoService;

@Service
public class HistoricoPagoServiceImpl implements HistoricoPagoService{

    @Autowired
    private HistoricoPagoRepository historicoPagoRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public List<HistoricoPago> buscar(String dni) {
        Empleado empleado = this.empleadoRepository.findById(dni).get();
        return empleado.getHistoricoPago();
    }

    @Override
    public List<HistoricoPago> obtenerPagosPorFecha(String dni, Date fechaInicio, Date fechaFin) {
        Empleado empleado = this.empleadoRepository.findById(dni).get();
        List<HistoricoPago> historicoPagosNuevo = new ArrayList<HistoricoPago>();
        if(empleado != null) {
            for (HistoricoPago pago : empleado.getHistoricoPago()) {
                if (pago.getFechaPago().after(fechaInicio) && pago.getFechaPago().before(fechaFin)) {
                    historicoPagosNuevo.add(pago);
                }
            }
        }
        return historicoPagosNuevo;
    }

    @Override
    public String guardarPago(String dni, int horasTrabajadas, Double precioHora) {
        Empleado empleado = this.empleadoRepository.findById(dni).get();
        if (empleado != null) {
            Double totalSueldo = horasTrabajadas * precioHora;
            HistoricoPago historicoPago = new HistoricoPago();
            historicoPago.setHorasTrabajadas(horasTrabajadas);
            historicoPago.setEmpleado(empleado);
            historicoPago.setPrecioPorHora(precioHora);
            historicoPago.setTotalSueldo(totalSueldo);
            this.historicoPagoRepository.save(historicoPago);
            return "Pago guardado";
        }
        return "Empleado no encontrado";
    }
    
}
