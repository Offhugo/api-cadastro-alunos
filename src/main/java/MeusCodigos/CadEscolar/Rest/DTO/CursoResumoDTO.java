package MeusCodigos.CadEscolar.Rest.DTO;

import MeusCodigos.CadEscolar.Model.CursoModel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoResumoDTO {
    private Long idCurso;
    private String nome;

}
