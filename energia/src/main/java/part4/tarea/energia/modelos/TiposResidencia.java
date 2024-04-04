package part4.tarea.energia.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tiposresidencia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TiposResidencia {
    
    @Id
    @Column(name = "idtiporesidencia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtiporesidencia;

    private String descripcion;

    private Double preciokw;

    @JsonIgnore
    @OneToOne(mappedBy = "tipoResidencia", cascade = CascadeType.ALL)
    private Abonado abonado;

}
