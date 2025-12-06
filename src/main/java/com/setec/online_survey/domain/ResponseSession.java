package com.setec.online_survey.domain;

import com.setec.online_survey.config.jpa.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "response_sessions",
       uniqueConstraints = {
           // Constraint 1: Registered User can only submit once per survey
           @UniqueConstraint(name = "UK_Registered_Response", columnNames = {"survey_id", "respondent_id"}),
           // Constraint 2: Anonymous user (identified by IP) can only submit once per survey
           @UniqueConstraint(name = "UK_Anonymous_Response", columnNames = {"survey_id", "ip_address"})
       }
)
@Entity
public class ResponseSession extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;

    // respondent_id is nullable for anonymous submissions
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "respondent_id") 
    private User respondent;

    @Column(name = "ip_address", length = 45) // Used for anonymous one-time check
    private String ipAddress;

    @Column(nullable = false)
    private LocalDateTime startTime;

    @Column(nullable = false)
    private LocalDateTime submitTime;

    @OneToMany(mappedBy = "session", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Answer> answers;
}