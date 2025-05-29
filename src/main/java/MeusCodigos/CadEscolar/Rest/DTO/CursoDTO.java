package MeusCodigos.CadEscolar.Rest.DTO;

import MeusCodigos.CadEscolar.Model.CursoModel;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
public class CursoDTO {

    private Long idCurso;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Column(name = "aluno", nullable = false)
    private String aluno;

    public CursoModel toModel(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, CursoModel.class);
    }
}
