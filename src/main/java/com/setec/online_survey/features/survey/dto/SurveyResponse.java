package com.setec.online_survey.features.survey.dto;

import java.time.LocalDateTime;

public record SurveyResponse(
        Long id,
        String title,
        String description,

        String status,
        LocalDateTime startDate,
        LocalDateTime closeDate,
        Integer maxResponses,
        Integer totalQuestions,           // derived
        Integer totalResponses           // derived from responseSessions.size()

){

}
