package com.setec.online_survey.mapper;

import com.setec.online_survey.domain.Option;
import com.setec.online_survey.domain.Question;
import com.setec.online_survey.features.option.dto.OptionRequest;
import com.setec.online_survey.features.option.dto.OptionResponse;
import com.setec.online_survey.features.question.dto.QuestionRequest;
import com.setec.online_survey.features.question.dto.QuestionResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question fromQuestionRequest(QuestionRequest questionRequest);

    QuestionResponse toQuestionResponse(Question question);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateQuestion(@MappingTarget Question question, QuestionRequest questionRequest);


}
