package part3.tarea.empleados.modelos;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "empleados")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empleado {

    @Id
    private String dni;

    private String nombre;

    private String apellido;

    @Column(name = "fechaingreso")
    private Date fechaIngreso;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<HistoricoPago> historicoPago;
}
