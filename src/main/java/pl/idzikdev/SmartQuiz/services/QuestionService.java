package pl.idzikdev.SmartQuiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.idzikdev.SmartQuiz.models.Category;
import pl.idzikdev.SmartQuiz.models.Question;
import pl.idzikdev.SmartQuiz.repositories.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository repository;

//    public void saveQuestion(Question question){
//        repository.save(question);
//    }

    public List<Question> findAllByCategory(Category category){
        return repository.findAllByCategory(category);
    }

    public Question getRandomQuestions(){
        List<Question> questions=findAllByCategory(Category.FIZYKA);
        return questions.get((int)(Math.random()*questions.size()));
    }

    public String getValidById(int id){
        return repository.queryQuestionById(id);
    }
}
