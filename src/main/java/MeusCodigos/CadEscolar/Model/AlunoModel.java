package MeusCodigos.CadEscolar.Model;

import MeusCodigos.CadEscolar.Rest.DTO.AlunoDTO;
import MeusCodigos.CadEscolar.Rest.DTO.CursoResumoDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAluno;

    @NotBlank(message = "Deve conter um nome")
    @Column(name = "nome", length = 255, nullable = false)
    private String nome;

    @Email(message = "Email inválido")
    @Column(name = "email", length = 255, nullable = false)
    private String email;

    @NotBlank
    @Column(name = "CPF", nullable = false)
    @Size(min = 11, max = 11, message = "O cpf deve conter 11 caracteres")
    private String cpf;

    @NotNull
    @Column(name = "dataNascimento", nullable = false)
    private LocalDate dataNascimento;

    @JsonIgnoreProperties("alunos")
    @ManyToOne  // Muitos alunos para UM curso
    @JoinColumn(name = "curso")  // Coluna FK na tabela Aluno
    private CursoModel curso;


}
