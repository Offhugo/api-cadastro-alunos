package MeusCodigos.CadEscolar.Repository;

import MeusCodigos.CadEscolar.Model.CursoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<CursoModel, Long> {

}
