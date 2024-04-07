package projetoshopeementoria;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "projetoshopeementoria.model")
@ComponentScan(basePackages = {"projetoshopeementoria.*"})
@EnableJpaRepositories(basePackages = {"projetoshopeementoria.repository"})
@EnableTransactionManagement
public class ProjetoShopeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoShopeeApplication.class, args);
	}

}
