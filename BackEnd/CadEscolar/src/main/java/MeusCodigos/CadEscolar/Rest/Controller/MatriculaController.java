package MeusCodigos.CadEscolar.Rest.Controller;

import MeusCodigos.CadEscolar.Rest.DTO.AlunoDTO;
import MeusCodigos.CadEscolar.Service.MatriculaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "matricula", description = "Gerencia operações envolvendo matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    @Operation(description = "Matricula um aluno em um curso utilizando seus IDs")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Matricula realizada com sucesso"),
            @ApiResponse(responseCode = "404", description = "Não foi possivel matricular o aluno no curso")
    })
    @PostMapping("/{idAluno}/cadastrar/{idCurso}")
    @Transactional
    public ResponseEntity<AlunoDTO> matricularAluno(
            @PathVariable long idAluno,
            @PathVariable long idCurso){

        AlunoDTO alunoMatriculado = matriculaService.matricularAluno(idAluno, idCurso);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoMatriculado);
    }
}
