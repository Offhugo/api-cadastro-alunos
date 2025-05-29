package MeusCodigos.CadEscolar.Service;

import MeusCodigos.CadEscolar.Exception.ObjectNotFoundException;
import MeusCodigos.CadEscolar.Model.AlunoModel;
import MeusCodigos.CadEscolar.Model.CursoModel;
import MeusCodigos.CadEscolar.Repository.AlunoRepository;
import MeusCodigos.CadEscolar.Repository.CursoRepository;
import MeusCodigos.CadEscolar.Rest.DTO.AlunoDTO;
import MeusCodigos.CadEscolar.Rest.DTO.CursoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {

    @Autowired
    public final ModelMapper modelMapper;

    public CursoService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional(readOnly = true)
    public List<CursoDTO> obterTodosCursos() {
        List<CursoModel> cursos = cursoRepository.findAll();
        return cursos.stream()
                .map(c -> c.toDTO())
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CursoDTO salvarNovoCurso(CursoModel cursoModel){
        return cursoRepository.save(cursoModel).toDTO();
    }

    @Transactional(readOnly = true)
    public List<AlunoDTO> obterAlunoDeCursoPorId(Long id){
        CursoModel curso = cursoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Aluno com ID " + id + " não encontrado"));

        return curso.getAlunos().stream()
                .map(a -> modelMapper.map(a, AlunoDTO.class))
                .collect(Collectors.toList());
    }
}
