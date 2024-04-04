package part4.tarea.energia.modelos;

import java.sql.Date;

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
@Table(name = "facturacion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Facturacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "fechafacturacion")
	private Date fechaFacturacion;

    @ManyToOne
    @JoinColumn(name = "dni", referencedColumnName = "dni")
    private Abonado dni;

    @Column(name = "kwsconsumidos")
    private Double kwsConsumidos;

    @Column(name = "totalfacturacion")
    private Double totalFacturacion;

}
