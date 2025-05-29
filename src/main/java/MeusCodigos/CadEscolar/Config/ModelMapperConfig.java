package MeusCodigos.CadEscolar.Config;

import MeusCodigos.CadEscolar.Model.AlunoModel;
import MeusCodigos.CadEscolar.Model.CursoModel;
import MeusCodigos.CadEscolar.Rest.DTO.AlunoDTO;
import MeusCodigos.CadEscolar.Rest.DTO.CursoResumoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper mapper = new ModelMapper();
        // Configurações adicionais (opcional)
        mapper.getConfiguration()
                .setSkipNullEnabled(true)
                .setAmbiguityIgnored(true);

        mapper.createTypeMap(CursoModel.class, CursoResumoDTO.class)
                .addMapping(CursoModel::getIdCurso, CursoResumoDTO::setIdCurso)
                .addMapping(CursoModel::getNome, CursoResumoDTO::setNome);

        mapper.createTypeMap(AlunoModel.class, AlunoDTO.class)
                .addMappings(m -> m.map(src -> src.getCurso(), AlunoDTO::setCurso));

        return mapper;
    }


}
