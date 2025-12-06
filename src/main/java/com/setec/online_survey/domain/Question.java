package com.setec.online_survey.domain;

// ...
import com.setec.online_survey.config.jpa.Auditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@Table(name = "questions")
@Entity
public class Question extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id", nullable = false)
    private Survey survey;

    @Column(columnDefinition = "CLOB", nullable = false)
    private String questionText;

    @Column(nullable = false, length = 50)
    private String questionType;

    @Column(nullable = false)
    @NotNull
    private Integer orderIndex;

    @Column(nullable = false)
    private Boolean isRequired = false;

    // ... relationships with Option and Answer
}