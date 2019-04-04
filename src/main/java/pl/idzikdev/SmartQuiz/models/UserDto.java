package pl.idzikdev.SmartQuiz.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class UserDto {
    private String login;
    private String role;
    private int score;
}
