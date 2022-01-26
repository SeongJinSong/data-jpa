package study.datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing(modifyOnCreate = false)
@SpringBootApplication
//@EnableJpaRepositories(basePackages = "study.datajpa.repository") // 부트에 포함되어있어서 명시안해도 된다.
public class DataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}

	@Bean
	public AuditorAware<String> auditorProvider(){
		//인터페이스에서 method가 1개면 람다로 변경할 수 있다.
		return ()-> Optional.of(UUID.randomUUID().toString());
	}
}
