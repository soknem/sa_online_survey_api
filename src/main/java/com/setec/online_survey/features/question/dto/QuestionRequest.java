package com.setec.online_survey.features.question.dto;

import com.setec.online_survey.domain.QuestionType;

import java.util.List;

public record QuestionRequest(
        Long id,
        String questionText,
        QuestionType questionType,
        Integer orderIndex,
        Boolean isRequired,
        List<QuestionRequest> options
) {
}
