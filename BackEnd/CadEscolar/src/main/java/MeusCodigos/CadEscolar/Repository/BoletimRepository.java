package MeusCodigos.CadEscolar.Repository;

import MeusCodigos.CadEscolar.domain.Model.BoletimModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoletimRepository extends JpaRepository<BoletimModel, Long> {
    Optional<BoletimModel> findByAluno_IdAluno(Long idAluno);
}
