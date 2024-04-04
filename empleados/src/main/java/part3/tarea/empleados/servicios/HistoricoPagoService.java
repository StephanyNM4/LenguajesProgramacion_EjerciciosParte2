package part3.tarea.empleados.servicios;


import java.sql.Date;
import java.util.List;

import part3.tarea.empleados.modelos.HistoricoPago;

public interface HistoricoPagoService {

        public List<HistoricoPago> buscar(String dni);

        public List<HistoricoPago> obtenerPagosPorFecha(String dni, Date fechaInicio, Date fechaFin);

        public String guardarPago(String dni, int horasTrabajadas, Double precioHora);
}
