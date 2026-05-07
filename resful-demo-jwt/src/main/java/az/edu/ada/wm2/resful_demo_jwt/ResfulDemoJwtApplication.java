package az.edu.ada.wm2.resful_demo_jwt;

import az.edu.ada.wm2.resful_demo_jwt.model.entity.User;
import az.edu.ada.wm2.resful_demo_jwt.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
@Slf4j
public class ResfulDemoJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResfulDemoJwtApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            var user = userRepository.save(User.builder()
                    .email("admin@gmail.com")
                    .fullName("admin")
                    .password(passwordEncoder.encode("admin"))
                    .build()
                    .addRole("ROLE_ADMIN")
            );
            log.info("Action: Inserted admin user: {}", user.toString());
        };
    }
}
