package com.biblioteca;

import com.biblioteca.entity.SituacaoUtilizador;
import com.biblioteca.entity.Utilizador;
import com.biblioteca.repository.UserRepository;
import com.biblioteca.entity.User;
import com.biblioteca.repository.UtilizadorRepository;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBibliotecaApplication {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UtilizadorRepository utilizadorRepository;
	
	@PostConstruct	
	public void initUsers() {
		List<User> users = Stream.of(
				new User(1, "anonimo", "$2a$10$ApEYM5EiNrOLhEAJ5hO94.4Jj2anVtfn5lhMGDtNyJCHm48jzIWeS",    "ROLE_ANONIMO"),
				new User(2, "utilizador", "$2a$10$ApEYM5EiNrOLhEAJ5hO94.4Jj2anVtfn5lhMGDtNyJCHm48jzIWeS", "ROLE_UTILIZADOR"),
				new User(3, "administrador", "$2a$10$ApEYM5EiNrOLhEAJ5hO94.4Jj2anVtfn5lhMGDtNyJCHm48jzIWeS", "ROLE_ADMIN")
				).collect(Collectors.toList());

		userRepository.saveAll(users);

		LocalDate localDate = LocalDate.of(2016, 8, 19);

		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		List<Utilizador> utilizadores = Stream.of(
				new Utilizador("Nome", "2018@email.com", "perfil",
							   date, SituacaoUtilizador.ATIVO)
		).collect(Collectors.toList());

		utilizadorRepository.saveAll(utilizadores);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBibliotecaApplication.class, args);
	}
}
