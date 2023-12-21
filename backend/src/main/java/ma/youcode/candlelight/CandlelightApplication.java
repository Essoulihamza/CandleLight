package ma.youcode.candlelight;

import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ma.youcode.candlelight.models.documents.User;
import ma.youcode.candlelight.repositories.UserRepository;


@SpringBootApplication
public class CandlelightApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandlelightApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(UserRepository repository) { 
		return args -> {
			User user1 = User.builder()
					.userName("hamza")
					.email("ceczrf.rferf@ref.mo")
					.password("cecec")
					.build();

			User user2 = User.builder()
					.userName("ahmed")
					.email("ahmed@ref.mo")
					.password("00000")
					.build();

			User user3 = User.builder()
					.userName("mosta")
					.email("mosta@ref.mo")
					.password("000011")
					.build();

			repository.saveAll(List.of(user1, user2, user3));
		};
	}

}
