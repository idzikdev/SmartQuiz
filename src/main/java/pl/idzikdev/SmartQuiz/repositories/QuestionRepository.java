package pl.idzikdev.SmartQuiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.idzikdev.SmartQuiz.models.Category;
import pl.idzikdev.SmartQuiz.models.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
        String queryAllByCategory="SELECT * FROM questions where category>?1";
        @Query(value=queryAllByCategory,nativeQuery = true)
        List<Question> findAllByCategory(Category category);

        String queryQuestionById="SELECT valid FROM questions where id=?1";
        @Query(value = queryQuestionById,nativeQuery = true)
        String queryQuestionById(int id);
    }

