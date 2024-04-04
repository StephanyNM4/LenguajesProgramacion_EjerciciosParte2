package part4.tarea.energia.modelos;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "abonado")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Abonado {

    @Id
	private String dni; 

    private String nombre; 

    private String apellido; 

    private String telefono; 

    @OneToOne()
    @JoinColumn(name = "idtiporesidencia", referencedColumnName = "idtiporesidencia")
    private TiposResidencia tipoResidencia;


    @OneToMany(mappedBy = "dni", cascade = CascadeType.ALL)
    private List<Facturacion> facturacion;
    
}
