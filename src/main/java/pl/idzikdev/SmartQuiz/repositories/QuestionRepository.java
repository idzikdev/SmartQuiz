package pl.idzikdev.SmartQuiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.idzikdev.SmartQuiz.models.Question;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
}
