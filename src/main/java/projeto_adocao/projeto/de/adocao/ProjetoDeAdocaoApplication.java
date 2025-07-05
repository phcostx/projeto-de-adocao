package projeto_adocao.projeto.de.adocao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("projeto_adocao.projeto.de.adocao.model")
@EnableJpaRepositories("projeto_adocao.projeto.de.adocao.repository")
public class ProjetoDeAdocaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoDeAdocaoApplication.class, args);
	}

}
