package pl.idzikdev.SmartQuiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.idzikdev.SmartQuiz.models.Category;
import pl.idzikdev.SmartQuiz.models.Question;
import pl.idzikdev.SmartQuiz.repositories.QuestionRepository;

import java.util.List;

//@PropertySource(value="classpath:sql.properties")
@Service
public class SystemService {
    @Autowired
    QuestionRepository repository;

    public void insertQuery(){
//        questionList.forEach(q->repository.save(q));
    }
}
