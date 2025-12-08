package com.setec.online_survey.features.question;

import com.setec.online_survey.domain.Question;
import com.setec.online_survey.features.question.dto.QuestionRequest;
import com.setec.online_survey.features.question.dto.QuestionResponse;
import com.setec.online_survey.mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService{

    private QuestionRepository questionRepository;
    private QuestionMapper questionMapper;


    @Override
    public void createQuestion(QuestionRequest questionRequest) {
        Question question = questionMapper.fromQuestionRequest(questionRequest);

        questionRepository.save(question);
    }

    @Override
    public QuestionResponse getQuestionByUuid(String uuid) {

        Question question = questionRepository.findQuestionByUuid(uuid).
                orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("question = %s has not been found",uuid)));

        return questionMapper.toQuestionResponse(question);
    }

    @Override
    public List<QuestionResponse> getAllQuestion() {
        return questionRepository.findAll().stream().map(questionMapper::toQuestionResponse).toList();
    }

    @Override
    public List<QuestionResponse> getQuestionBySurveyUuid(String surveyUuid) {
        return questionRepository.findQuestionBySurveyUuid(surveyUuid).stream().map(questionMapper::toQuestionResponse).toList();
    }

    @Override
    public QuestionResponse updateQuestionByUuid(QuestionRequest questionRequest,String questionUuid) {

        Question question = questionRepository.findQuestionByUuid(questionUuid)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("question = %s has not been found",questionUuid)));

        questionMapper.updateQuestion(question,questionRequest);

        questionRepository.save(question);

        return  questionMapper.toQuestionResponse(question);


    }

    @Override
    public void deleteQuestionByUuid(String questionUuid) {

        Question question = questionRepository.findQuestionByUuid(questionUuid)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("question = %s has not been found",questionUuid)));

        questionRepository.delete(question);
    }
}
