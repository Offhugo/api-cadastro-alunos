package MeusCodigos.CadEscolar.Repository;

import MeusCodigos.CadEscolar.domain.Model.MateriaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<MateriaModel, Long> {
}
