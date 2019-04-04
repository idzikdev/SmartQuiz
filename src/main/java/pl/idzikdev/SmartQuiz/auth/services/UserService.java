package pl.idzikdev.SmartQuiz.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.idzikdev.SmartQuiz.auth.entities.UserEntity;
import pl.idzikdev.SmartQuiz.auth.forms.LoginForm;
import pl.idzikdev.SmartQuiz.auth.forms.RegisterForm;
import pl.idzikdev.SmartQuiz.auth.repositories.UserRepository;
import pl.idzikdev.SmartQuiz.models.UserDto;

import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.Optional;

@Service
@PersistenceContext(type = PersistenceContextType.EXTENDED)
public class UserService {
    public enum LoginResponse {
        SUCCESS, BAD_CREDENTIALS, BANNED;
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserSession userSession;



    public boolean registerUser(RegisterForm registerForm) {
        if (!isLoginFree(registerForm.getLogin())) {
            return false;
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setEmail(registerForm.getEmail());
        userEntity.setLogin(registerForm.getLogin());
        userEntity.setPassword(getBCrypt().encode(registerForm.getPassword()));

        userRepository.save(userEntity);
        return true;
    }

    public LoginResponse login(LoginForm loginForm) {
        Optional<UserEntity> userOptional = userRepository.findByLogin(loginForm.getLogin());
        if (!userOptional.isPresent()) {
            return LoginResponse.BAD_CREDENTIALS;
        }

        if (!getBCrypt().matches(loginForm.getPassword(), userOptional.get().getPassword())) {
            return LoginResponse.BAD_CREDENTIALS;
        }

        userSession.setLogin(true);
        userSession.setUserEntity(userOptional.get());
        return LoginResponse.SUCCESS;
    }

    public void logout() {
        userSession.setLogin(false);
        userSession.setUserEntity(null);
    }

    private boolean isLoginFree(String login) {
        return !userRepository.existsByLogin(login);
    }

    public UserDto getUserDto(){
        UserEntity user=userSession.getUserEntity();
        UserDto userDto=new UserDto(user.getLogin(),user.getRole(),user.getScore());
        return userDto;
    }

    @Bean
    public BCryptPasswordEncoder getBCrypt() {
        return new BCryptPasswordEncoder();
    }
}
