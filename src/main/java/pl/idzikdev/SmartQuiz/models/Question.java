package pl.idzikdev.SmartQuiz.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "questions")
public class Question {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "category")
    private Category category;
    @Column(name = "question")
    private String question;
    @Column(name = "a")
    private String answerA;
    @Column(name = "b")
    private String answerB;
    @Column(name = "c")
    private String answerC;
    @Column(name = "d")
    private String answerD;
    @Column(name = "valid")
    private String valid;
}
