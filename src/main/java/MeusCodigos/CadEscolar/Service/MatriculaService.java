package MeusCodigos.CadEscolar.Service;

import MeusCodigos.CadEscolar.Exception.BadRequestException;
import MeusCodigos.CadEscolar.Model.AlunoModel;
import MeusCodigos.CadEscolar.Model.CursoModel;
import MeusCodigos.CadEscolar.Repository.AlunoRepository;
import MeusCodigos.CadEscolar.Repository.CursoRepository;
import MeusCodigos.CadEscolar.Rest.DTO.AlunoDTO;
import MeusCodigos.CadEscolar.Rest.DTO.CursoResumoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MatriculaService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = true)
    public AlunoDTO matricularAluno(Long idAluno, Long idCurso){
        AlunoModel aluno = alunoRepository.findById(idAluno)
                .orElseThrow(() -> new BadRequestException("Aluno com ID " + idAluno + " não encontrado"));
        CursoModel curso = cursoRepository.findById(idCurso)
                .orElseThrow(() -> new BadRequestException("Curso com ID " + idCurso + " não encontrado"));
        ;

        if (aluno.getCurso() != null) {
            throw new BadRequestException("Aluno já está matriculado em um curso");
        }

        curso.adicionarAluno(aluno);
        // SE espera um cursoResumoDTO
        alunoRepository.save(aluno);
        return modelMapper.map(aluno, AlunoDTO.class);
    }
}
