package MeusCodigos.CadEscolar.Rest.Controller;

import MeusCodigos.CadEscolar.Model.AlunoModel;
import MeusCodigos.CadEscolar.Rest.DTO.AlunoDTO;
import MeusCodigos.CadEscolar.Rest.DTO.CursoDTO;
import MeusCodigos.CadEscolar.Service.AlunoService;
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
public class AlunoController {

    @Autowired
    private AlunoService alunoService;


    @GetMapping("/all")
    @Transactional
    public ResponseEntity<List<AlunoDTO>> listarTodos() {
        List<AlunoDTO> alunosDTOs = alunoService.obterTodosAlunos();
        return ResponseEntity.ok(alunosDTOs);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<AlunoDTO> listarAlunoPorId(@PathVariable long id) {
        return ResponseEntity.ok(alunoService.obterPorId(id));
    }

    @GetMapping("/buscarNome")
    @Transactional
    public ResponseEntity<AlunoDTO> listarAlunoPorNome(@Valid @RequestParam(required = false) String nome) {
        return ResponseEntity.ok((AlunoDTO) alunoService.findByNome(nome));
    }

    @GetMapping("/{id}/cursos")
    @Transactional
    public ResponseEntity<Optional<CursoDTO>> listarCursoDeAlunoPorId(@PathVariable long id) {
        return ResponseEntity.ok(alunoService.obterCursoDeAlunoPorId(id));
    }

    @PostMapping
    public ResponseEntity<AlunoDTO> salvarAluno (@Valid @RequestBody AlunoModel novoAluno) {
        AlunoDTO aluno = alunoService.salvarNovoAluno(novoAluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(aluno);
    }

}
