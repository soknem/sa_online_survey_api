package com.setec.online_survey.init;

import com.setec.online_survey.domain.User;
import com.setec.online_survey.domain.UserRole;
import com.setec.online_survey.features.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInit {


    private final UserRepository userRepository;
    //private final PasswordEncoder passwordEncoder;


    @PostConstruct
    void initUser() {
        // Auto generate user (USER, CUSTOMER, STAFF, ADMIN)
        if (userRepository.count() < 1) {

            User user = new User();
            user.setRole(UserRole.ROLE_USER);
            user.setEmail("sokname@gmail.com");
            user.setLastName("soknem");
            user.setFirstName("pov");
            user.setUsername("sokname56@gmail.com");
            userRepository.save(user);

        }
    }
}
