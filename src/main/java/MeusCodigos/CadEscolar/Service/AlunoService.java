package MeusCodigos.CadEscolar.Service;

import MeusCodigos.CadEscolar.Exception.BadRequestException;
import MeusCodigos.CadEscolar.Exception.ObjectNotFoundException;
import MeusCodigos.CadEscolar.Model.AlunoModel;
import MeusCodigos.CadEscolar.Model.CursoModel;
import MeusCodigos.CadEscolar.Repository.AlunoRepository;
import MeusCodigos.CadEscolar.Repository.CursoRepository;
import MeusCodigos.CadEscolar.Rest.DTO.AlunoDTO;
import MeusCodigos.CadEscolar.Rest.DTO.CursoDTO;
import MeusCodigos.CadEscolar.Rest.DTO.CursoResumoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlunoService {

    @Autowired
    public final ModelMapper modelMapper;

    public AlunoService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;


    @Transactional(readOnly = true)
    public List<AlunoDTO> obterTodosAlunos() {
        List<AlunoModel> alunos = alunoRepository.findAll();
        return alunos.stream()
                .map(a -> modelMapper.map(a, AlunoDTO.class))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<AlunoDTO> findByNome (String nome) {
        return alunoRepository.findByNome(nome);
    }

    @Transactional(readOnly = true)
    public AlunoDTO obterPorId(Long id){
        AlunoModel aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Aluno com ID " + id + " não encontrado"));
        return modelMapper.map(aluno, AlunoDTO.class);
    }

    @Transactional(readOnly = true)
    public Optional<CursoDTO> obterCursoDeAlunoPorId(Long id){
        return alunoRepository.findById(id)
                .map(a -> a.getCurso())
                .map(curso -> modelMapper.map(curso, CursoDTO.class));
    }

    @Transactional(readOnly = true)
    public AlunoDTO salvarNovoAluno(AlunoModel alunoModel){
        AlunoModel alunoSalvo = alunoRepository.save(alunoModel);
        return modelMapper.map(alunoSalvo, AlunoDTO.class);
    }

}
