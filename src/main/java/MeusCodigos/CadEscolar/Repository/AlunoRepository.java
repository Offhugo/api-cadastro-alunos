package MeusCodigos.CadEscolar.Repository;

import MeusCodigos.CadEscolar.Model.AlunoModel;
import MeusCodigos.CadEscolar.Rest.DTO.AlunoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {

    List<AlunoDTO> findByNome(String nome);
}
