package MeusCodigos.CadEscolar.Rest.DTO;

import MeusCodigos.CadEscolar.domain.Model.CursoModel;
import MeusCodigos.CadEscolar.domain.Model.MateriaModel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "CursoDTO", description = "Objeto de traferência de dados do curso")
public class CursoDTO {

    @Schema(description = "ID do curso", example = "1")
    private Long idCurso;

    @Schema(description = "Nome do curso", example = "Fisioterapia")
    @Column(name = "nome", nullable = false)
    private String nome;

    @Schema(description = "Descrição do curso", example = "O curso tem 4 anos de duração e envolve...")
    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Schema(description = "Categoria do curso", example = "Saúde")
    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Schema(description = "Aluno matriculado no curso", example = "Estevão")
    @Column(name = "aluno", nullable = false)
    private AlunoDTO aluno;

    @Schema(description = "Materia do curso", example = "Calculo 1")
    @Column(name = "materia", nullable = false)
    private List<MateriaDTO> materias;

    public CursoModel toModel(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, CursoModel.class);
    }
}
