package com.setec.online_survey.domain;

import com.setec.online_survey.config.jpa.Auditable;
import com.setec.online_survey.domain.UserRole; // Import the new Enum
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "users")
@Entity
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    @Size(max = 100)
    private String username;

    @Column(nullable = false, unique = true, length = 255)
    @Email
    @Size(max = 255)
    private String email;

    @Column(length = 100)
    private String firstName;

    @Column(length = 100)
    private String lastName;

    // --- Role is now an Enum ---
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private UserRole role = UserRole.ROLE_RESPONDENT; // Default role
    // ---------------------------

    @OneToMany(mappedBy = "creator", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Survey> createdSurveys;

    @OneToMany(mappedBy = "respondent", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ResponseSession> submittedResponses;
}