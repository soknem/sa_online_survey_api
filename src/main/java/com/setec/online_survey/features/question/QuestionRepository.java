package com.setec.online_survey.features.question;

import com.setec.online_survey.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question,Long> {

    Optional<Question> findQuestionByUuid(String uuid);

    List<Question> findQuestionBySurveyUuid(String uuid);
}
