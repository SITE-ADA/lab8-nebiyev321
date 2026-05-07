package az.edu.ada.wm2.resful_demo_jwt.repository;

import az.edu.ada.wm2.resful_demo_jwt.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

}
