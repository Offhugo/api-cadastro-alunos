package MeusCodigos.CadEscolar.Rest.Controller;

import MeusCodigos.CadEscolar.Rest.DTO.AlunoDTO;
import MeusCodigos.CadEscolar.Service.AlunoService;
import MeusCodigos.CadEscolar.Service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("matricula")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    // FALTA TESTAR
    @PostMapping("/{idAluno}/matricular/{idCurso}")
    @Transactional
    public ResponseEntity<AlunoDTO> matricularAluno(
            @PathVariable long idAluno,
            @PathVariable long idCurso){

        AlunoDTO alunoMatriculado = matriculaService.matricularAluno(idAluno, idCurso);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoMatriculado);
    }
}
