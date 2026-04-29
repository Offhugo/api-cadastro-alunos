package MeusCodigos.CadEscolar.Service;

import MeusCodigos.CadEscolar.Exception.BadRequestException;
import MeusCodigos.CadEscolar.Repository.BoletimRepository;
import MeusCodigos.CadEscolar.Repository.MateriaRepository;
import MeusCodigos.CadEscolar.domain.Enums.StatusMateria;
import MeusCodigos.CadEscolar.domain.Model.*;
import MeusCodigos.CadEscolar.Repository.AlunoRepository;
import MeusCodigos.CadEscolar.Repository.CursoRepository;
import MeusCodigos.CadEscolar.Rest.DTO.AlunoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MatriculaService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private BoletimRepository boletimRepository;

    @Autowired
    private MateriaRepository materiaRepository;

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

        // 2) Cria boletim (um por aluno no modelo atual)
        if (boletimRepository.findByAluno_IdAluno(aluno.getIdAluno()).isPresent()) {
            throw new BadRequestException("Aluno já possui boletim cadastrado");
        }

        BoletimModel boletim = new BoletimModel();
        boletim.setAluno(aluno);

        List<MateriaModel> materiasDoCurso = materiaRepository.findAllByCursoModelj_IdCurso(curso.getIdCurso());

        for (MateriaModel materia : materiasDoCurso) {
            ItemBoletimModel item = new ItemBoletimModel();
            item.setBoletim(boletim);
            item.setMateriaModel(materia);
            item.setNota(0.0);
            item.setStatus(StatusMateria.EM_ANDAMENTO);

            boletim.getItens().add(item);
        }

        boletimRepository.save(boletim);

        return modelMapper.map(aluno, AlunoDTO.class);
    }
}
