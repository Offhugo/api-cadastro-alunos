package MeusCodigos.CadEscolar.Rest.DTO;

import MeusCodigos.CadEscolar.domain.Enums.StatusMateria;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "ItemBoletimDTO", description = "Representação da nota de uma matéria específica")
public class ItemBoletimDTO {

    @Schema(description = "ID do item", example = "101")
    private Long id;

    // Em vez de MateriaModel, usamos o DTO
    @Schema(description = "Dados da matéria")
    private MateriaDTO materia;

    @NotNull
    @Min(0)
    @Max(10)
    @Schema(description = "Nota do aluno", example = "9.5")
    private Double nota;

    @Schema(description = "Status da matéria (APROVADO, REPROVADO, etc)")
    private StatusMateria statusMateria;
}
