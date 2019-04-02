package pl.idzikdev.SmartQuiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.idzikdev.SmartQuiz.models.Question;
import pl.idzikdev.SmartQuiz.repositories.QuestionRepository;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository repository;

    public void saveQuestion(Question question){
        repository.save(question);
    }
}
