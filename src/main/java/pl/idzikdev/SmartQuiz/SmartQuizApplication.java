package pl.idzikdev.SmartQuiz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.idzikdev.SmartQuiz.models.Category;
import pl.idzikdev.SmartQuiz.models.Question;

@SpringBootApplication
public class SmartQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartQuizApplication.class, args);
	}
}
