package MeusCodigos.CadEscolar.Rest.DTO;

import MeusCodigos.CadEscolar.Model.AlunoModel;
import MeusCodigos.CadEscolar.Model.CursoModel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "AlunoDTO", description = "Objeto de transferência de dados para aluno")
public class AlunoDTO {

    @Schema(description = "Nome do aluno", example = "Hugo Mendes")
    @Column(name = "nome", nullable = false)
    private String nome;

    @Schema(description = "E-mail do aluno", example = "hugo.mendes.313@gmail.com")
    @Column(name = "email", nullable = false)
    private String email;

    @Schema(description = "CPF do aluno", example = "123.456.789-10")
    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Schema(description = "Data de nascimento do aluno", example = "2019-05-17")
    @Column(name = "dataNascimento", nullable = false)
    private LocalDate dataNascimento;

    @Schema(description = "Curso que do aluno", example = "Fisioterapia")
    @Column(name = "curso", nullable = false)
    private CursoModel curso;

}
