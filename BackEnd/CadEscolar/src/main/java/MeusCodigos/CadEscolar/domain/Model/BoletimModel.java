package MeusCodigos.CadEscolar.domain.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(
        name = "boletim",
        uniqueConstraints = {
                @UniqueConstraint(name = "uk_aluno_curso", columnNames = {"aluno_id"})
        },
        indexes = {
                @Index(name = "idx_boletim_aluno", columnList = "aluno_id")
        }
)
public class BoletimModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aluno_id", nullable = false)
    private AlunoModel aluno;

    @OneToMany(mappedBy = "boletim", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemBoletimModel> itens = new ArrayList<>();
}
