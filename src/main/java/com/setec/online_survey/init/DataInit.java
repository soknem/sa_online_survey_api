package com.setec.online_survey.init;

import com.setec.online_survey.domain.User;
import com.setec.online_survey.domain.UserRole;
import com.setec.online_survey.features.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder; // <-- IMPORTANT
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInit {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // <-- UNCOMMENTED and injected

    @PostConstruct
    void initUser() {
        // Only run if no users exist
        if (userRepository.count() == 0) { 

            // --- 1. Create a primary Admin/User ---
            User adminUser = new User();
            
            // Set basic details
            adminUser.setEmail("admin@setec.com");
            adminUser.setLastName("Admin");
            adminUser.setFirstName("Super");
            adminUser.setRole(UserRole.ROLE_ADMIN); // Set a high privilege role
            
            // Set mandatory password (must be hashed!)
            adminUser.setPassword(passwordEncoder.encode("123456")); // <-- HASHED PASSWORD
            
            // Save the user
            userRepository.save(adminUser);

            
            // --- 2. Create a standard Respondent user (Optional, for testing) ---
            User respondentUser = new User();
            respondentUser.setEmail("respondent@setec.com");
            respondentUser.setLastName("User");
            respondentUser.setFirstName("Test");
            respondentUser.setRole(UserRole.ROLE_RESPONDENT);
            respondentUser.setPassword(passwordEncoder.encode("123456"));
            userRepository.save(respondentUser);
            
            
            // --- 3. Create a user with the USER role (from your original snippet) ---
            User genericUser = new User();
            genericUser.setEmail("sokname@gmail.com");
            genericUser.setLastName("soknem");
            genericUser.setFirstName("pov");
            genericUser.setRole(UserRole.ROLE_USER);
            genericUser.setPassword(passwordEncoder.encode("123456"));
            userRepository.save(genericUser);

        }
    }
}