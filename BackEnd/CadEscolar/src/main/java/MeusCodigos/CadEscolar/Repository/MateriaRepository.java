package MeusCodigos.CadEscolar.Repository;

import MeusCodigos.CadEscolar.domain.Model.MateriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MateriaRepository extends JpaRepository<MateriaModel, Long> {
    List<MateriaModel> findAllByCursoModelj_IdCurso(Long idCurso);
}
