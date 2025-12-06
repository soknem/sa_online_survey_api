package com.setec.online_survey.domain;

import com.setec.online_survey.config.jpa.Auditable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Table(name = "reports")
@Entity
public class Report extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "survey_id", nullable = false, unique = true)
    private Survey survey;

    @Column(nullable = false)
    private LocalDateTime generatedTime;

    @Column(nullable = false)
    @NotNull
    private Integer totalResponses;

    @Column(columnDefinition = "CLOB")
    private String summaryData;
}