package MeusCodigos.CadEscolar.Rest.Controller;

import MeusCodigos.CadEscolar.Model.CursoModel;
import MeusCodigos.CadEscolar.Rest.DTO.AlunoDTO;
import MeusCodigos.CadEscolar.Rest.DTO.CursoDTO;
import MeusCodigos.CadEscolar.Service.CursoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
@RequiredArgsConstructor
@Tag(name = "Curso", description = "Gerencia as operações relacionadas ao curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @Operation(description = "Busca todos os cursos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a lista de cursos"),
            @ApiResponse(responseCode = "400", description = "Não encontrou a lista de cursos")
    })
    @GetMapping("/all")
    @Transactional
    public ResponseEntity<List<CursoDTO>> obterTodosOsCursos () {
        List<CursoDTO> cursosDTO = cursoService.obterTodosCursos();
        return ResponseEntity.ok(cursosDTO);
    }

    @Operation(description = "Salva um novo cursp")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cria um novo curso"),
            @ApiResponse(responseCode = "400", description = "Não conseguiu criar um novo aluno")
    })
    @PostMapping
    @Transactional
    public ResponseEntity<CursoDTO> salvarCurso (@Valid @RequestBody CursoModel cursoModel) {
        CursoDTO novoCurso = cursoService.salvarNovoCurso(cursoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCurso);
    }

    @Operation(description = "Busca o curso pelo id do mesmo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Retorna o curso de acordo com o id"),
            @ApiResponse(responseCode = "404", description = "Não encontrou o curso pelo id do mesmo")
    })
    @GetMapping("/{id}/cursos")
    @Transactional
    public ResponseEntity<List<AlunoDTO>> obterAlunosDoCurso (@PathVariable long id) {
        List<AlunoDTO> alunosDoCurso = cursoService.obterAlunoDeCursoPorId(id);
        return ResponseEntity.ok(alunosDoCurso);
    }
}
