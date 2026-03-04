package MeusCodigos.CadEscolar.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Cadastro Acadêmico")
                        .version("1.0.0")
                        .description("API para gerenciamento de alunos e cursos")
                        .contact(new Contact()
                                .name("Desenvolvedor")
                                .email("hugo.mendes.313@gmail.com")));
    }
}
