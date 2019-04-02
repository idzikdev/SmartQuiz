package pl.idzikdev.SmartQuiz.auth.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.idzikdev.SmartQuiz.auth.entities.UserEntity;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    boolean existsByLogin(String login);
    Optional<UserEntity> findByLogin(String login);
}
