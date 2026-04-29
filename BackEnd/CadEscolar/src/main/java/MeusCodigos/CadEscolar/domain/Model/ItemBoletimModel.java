package MeusCodigos.CadEscolar.domain.Model;

import MeusCodigos.CadEscolar.domain.Enums.StatusMateria;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "item_boletim", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"boletim_id", "materia_id"}) // Diz ao banco que essa combinação só pode aparecer uma vez, mas eles separadamente não
})
public class ItemBoletimModel { // Entidade intermediaria

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boletim_id", nullable = false)
    private BoletimModel boletim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "materia_id", nullable = false)
    private MateriaModel materiaModel;

    @NotNull
    @Min(0)
    @Max(10)
    private Double nota;

    @Enumerated(EnumType.STRING)
    private StatusMateria status;
}
