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
    public class Question extends Auditable<String>  {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String uuid;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "survey_id", nullable = false)
        private Survey survey;

        @Column(columnDefinition = "CLOB", nullable = false)
        private String questionText;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false, length = 50)
        private QuestionType questionType = QuestionType.MULTIPLE_CHOICE;

        @Column(nullable = false)
        @NotNull
        private Integer orderIndex;

        @Column(nullable = false)
        private Boolean isRequired = false;

        // ... relationships with Option and Answer
    }