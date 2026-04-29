package MeusCodigos.CadEscolar.Rest.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MateriaDTO {

    @Schema(description = "Nome da materia", example = "Estrutura de dados")
    @Column(name = "nome", nullable = false)
    private String nome;

    @Schema(description = "Curso em que a materia é associada", example = "Física")
    @Column(name = "curso", nullable = false)
    private CursoDTO cursoDTO;
}
