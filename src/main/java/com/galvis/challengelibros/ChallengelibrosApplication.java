package com.galvis.challengelibros;

import com.galvis.challengelibros.principal.Principal;
import com.galvis.challengelibros.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengelibrosApplication implements CommandLineRunner {

	@Autowired
	private LibroRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ChallengelibrosApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);
		principal.muestraElMenu();
	}
}

//@SpringBootApplication
//public class DesafioApplication implements CommandLineRunner {
//
//	public static void main(String[] args) {
//		SpringApplication.run(DesafioApplication.class, args);
//	}
//
//	@Override
//	public void run(String... args) throws Exception {
//		Principal principal = new Principal();
//		principal.muestraElMenu();
//
//	}
//}
