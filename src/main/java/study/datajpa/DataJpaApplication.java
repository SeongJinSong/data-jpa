package study.datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackages = "study.datajpa.repository") // 부트에 포함되어있어서 명시안해도 된다.
public class DataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}

}
