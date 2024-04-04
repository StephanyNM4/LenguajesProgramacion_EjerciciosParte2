package part4.tarea.energia.servicios;

import part4.tarea.energia.modelos.Abonado;

public interface AbonadoService {
    

    public Abonado guardarAbonado(Abonado abonado);

    public Abonado obtenerAbonado(String dni);

    public String eliminarAbonado(String dni);


}
