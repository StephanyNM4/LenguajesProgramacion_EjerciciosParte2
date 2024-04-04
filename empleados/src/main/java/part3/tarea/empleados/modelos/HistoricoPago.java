package part3.tarea.empleados.modelos;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "historicopagos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HistoricoPago {

    @Id
    @Column(name = "idhistorico")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistorico;

    @Column(name = "fechapago")
    private Date fechaPago;

    @Column(name = "horastrabajadas")
    private int horasTrabajadas;

    @Column(name = "precioporhora")
    private Double precioPorHora;

    @Column(name = "totalsueldo")
    private Double totalSueldo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Empleado empleado;
    
}
