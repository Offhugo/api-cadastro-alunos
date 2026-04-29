package MeusCodigos.CadEscolar.domain.Model;

import MeusCodigos.CadEscolar.Rest.DTO.CursoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "curso")
@EqualsAndHashCode(exclude = "alunos")
public class CursoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCurso")
    private Long idCurso;

    @NotBlank(message = "Deve Conter algum valor")
    @Column(name = "nome", length = 255,nullable = false)
    private String nome;

    @NotBlank(message = "Deve conter algum valor")
    @Column(name = "descricao", length = 255, nullable = false)
    private String descricao;

    @NotBlank(message = "Deve conter algum valor")
    @Column(name = "categoria", length = 255, nullable = false)
    private String categoria;

    @NotNull(message = "Deve conter algum valor")
    @ManyToMany
    @JoinTable(
            name = "curso_materia",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "materia_id")
    )
    private List<MateriaModel> materias;

    // Relacionamento bidirecional
    @JsonIgnore
    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AlunoModel> alunos = new ArrayList<>(); // Inicialize a lista!

    // Método conveniente para adicionar aluno
    public void adicionarAluno(AlunoModel aluno) {
        alunos.add(aluno);
        aluno.setCurso(this);
    }

    // Método conveniente para remover aluno
    public void removerAluno(AlunoModel aluno) {
        alunos.remove(aluno);
        aluno.setCurso(null);
    }

    public CursoDTO toDTO(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, CursoDTO.class);
    }
}
