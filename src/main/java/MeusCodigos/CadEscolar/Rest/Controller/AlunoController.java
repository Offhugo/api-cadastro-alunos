package MeusCodigos.CadEscolar.Rest.Controller;

import MeusCodigos.CadEscolar.Model.AlunoModel;
import MeusCodigos.CadEscolar.Rest.DTO.AlunoDTO;
import MeusCodigos.CadEscolar.Rest.DTO.CursoDTO;
import MeusCodigos.CadEscolar.Service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("alunos")
@RequiredArgsConstructor
@Tag(name = "alunos", description = "Gerencia as operações que envolvem o aluno")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;


    @Operation(description = "Busca todos os alunos cadastrados")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna a lista completa"),
            @ApiResponse(responseCode = "404", description = "Não encontrou a lista")
    })
    @GetMapping("/all")
    @Transactional
    public ResponseEntity<List<AlunoDTO>> listarTodos() {
        List<AlunoDTO> alunosDTOs = alunoService.obterTodosAlunos();
        return ResponseEntity.ok(alunosDTOs);
    }

    @Operation(description = "Busco o aluno pelo ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna aluno solicitado"),
            @ApiResponse(responseCode = "404", description = "Não encontrou o aluno solicitado pelo id")
    })
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<AlunoDTO> listarAlunoPorId(@PathVariable long id) {
        return ResponseEntity.ok(alunoService.obterPorId(id));
    }

    @Operation
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca de acordo com o nome do aluno"),
            @ApiResponse(responseCode = "404", description = "Não encontrou o aluno solicitado pelo nome")
    })
    @GetMapping("/buscarNome")
    @Transactional
    public ResponseEntity<AlunoDTO> listarAlunoPorNome(@Valid @RequestParam(required = false) String nome) {
        return ResponseEntity.ok((AlunoDTO) alunoService.findByNome(nome));
    }

    @Operation(description = "Busco o curso do aluno pelo id do mesmo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o curso vinculado ao id do aluno"),
            @ApiResponse(responseCode = "400", description = "Não encontrou o curso do aluno ou aluno não existe")
    })
    @GetMapping("/{id}/cursos")
    @Transactional
    public ResponseEntity<Optional<CursoDTO>> listarCursoDeAlunoPorId(@PathVariable long id) {
        return ResponseEntity.ok(alunoService.obterCursoDeAlunoPorId(id));
    }

    @Operation(description = "Salva um novo aluno")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Um novo aluno foi criado"),
            @ApiResponse(responseCode = "404", description = "Não foi possivel criar um novo aluno")
    })
    @PostMapping
    public ResponseEntity<AlunoDTO> salvarAluno (@Valid @RequestBody AlunoModel novoAluno) {
        AlunoDTO aluno = alunoService.salvarNovoAluno(novoAluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

}
