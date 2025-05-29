package MeusCodigos.CadEscolar.Rest.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "CursoResumoDTO", description = "Objeto de tranferência de dados que resume dados do CursoDTO")
public class CursoResumoDTO {
    @Schema(description = "ID do curso", example = "1")
    private Long idCurso;

    @Schema(description = "Nome do curso", example = "Medicina")
    private String nome;

}
