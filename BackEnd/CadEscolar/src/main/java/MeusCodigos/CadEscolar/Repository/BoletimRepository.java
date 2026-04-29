package MeusCodigos.CadEscolar.Repository;

import MeusCodigos.CadEscolar.domain.Model.BoletimModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoletimRepository extends JpaRepository<BoletimModel, Long> {
}
