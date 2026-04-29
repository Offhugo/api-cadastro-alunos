package MeusCodigos.CadEscolar.Rest.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "BoletimDTO", description = "Representação completa do boletim do aluno")
public class BoletimDTO {

    @Schema(description = "ID do boletim", example = "10")
    private Long id;

    // Usamos um DTO de resumo para não trazer dados desnecessários do aluno
    @Schema(description = "Dados resumidos do aluno")
    private AlunoDTO aluno;

    @Schema(description = "Lista de itens (notas e matérias) do boletim")
    private List<ItemBoletimDTO> itens = new ArrayList<>();
}