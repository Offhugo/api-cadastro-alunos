package MeusCodigos.CadEscolar.Rest.Controller;

import MeusCodigos.CadEscolar.Model.CursoModel;
import MeusCodigos.CadEscolar.Rest.DTO.AlunoDTO;
import MeusCodigos.CadEscolar.Rest.DTO.CursoDTO;
import MeusCodigos.CadEscolar.Service.CursoService;
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
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping("/all")
    @Transactional
    public ResponseEntity<List<CursoDTO>> obterTodosOsCursos () {
        List<CursoDTO> cursosDTO = cursoService.obterTodosCursos();
        return ResponseEntity.ok(cursosDTO);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<CursoDTO> salvarCurso (@Valid @RequestBody CursoModel cursoModel) {
        CursoDTO novoCurso = cursoService.salvarNovoCurso(cursoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCurso);
    }

    // FALTA VERIFICAR
    @GetMapping("/{id}/cursos")
    @Transactional
    public ResponseEntity<List<AlunoDTO>> obterAlunosDoCurso (@PathVariable long id) {
        List<AlunoDTO> alunosDoCurso = cursoService.obterAlunoDeCursoPorId(id);
        return ResponseEntity.ok(alunosDoCurso);
    }
}
