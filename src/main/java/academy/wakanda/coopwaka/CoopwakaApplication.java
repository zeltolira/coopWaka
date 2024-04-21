package academy.wakanda.coopwaka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableScheduling
@RestController
@RequestMapping("/")
public class CoopwakaApplication {
	@GetMapping
	public String testeHome(){
		return "teste Wakacop";
	}
	public static void main(String[] args) {
		SpringApplication.run(CoopwakaApplication.class, args);
	}

}
