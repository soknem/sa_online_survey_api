package com.setec.online_survey.features.survey;

import com.setec.online_survey.domain.Survey;
import com.setec.online_survey.features.survey.dto.SurveyRequest;
import com.setec.online_survey.features.survey.dto.SurveyResponse;
import com.setec.online_survey.mapper.SurveyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;


@Service
@RequiredArgsConstructor
public class SurveyServiceImpl implements SurveyService{

    private SurveyRepository surveyRepository;
    private SurveyMapper surveyMapper;

    @Override
    public void createSurvey(SurveyRequest surveyRequest) {
        Survey survey = surveyMapper.fromSurveyRequest(surveyRequest);

        surveyRepository.save(survey);
    }

    @Override
    public SurveyResponse getSurveyByUuid(String uuid) {

        Survey survey =surveyRepository.findSurveyByUuid(uuid)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("survey = %s has not been found",uuid)));

        return surveyMapper.toSurveyResponse(survey);
    }

    @Override
    public List<SurveyResponse> getAllSurvey() {
        return surveyRepository.findAll().stream().map(surveyMapper::toSurveyResponse).toList();
    }

    @Override
    public void deleteSurveyByUuid(String uuid) {

        Survey survey =surveyRepository.findSurveyByUuid(uuid)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("survey = %s has not been found",uuid)));

        surveyRepository.delete(survey);
    }

    @Override
    public SurveyResponse updateSurveyByUuid(SurveyRequest surveyRequest,String uuid) {


        Survey survey =surveyRepository.findSurveyByUuid(uuid)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("survey = %s has not been found",uuid)));

        surveyMapper.updateSurvey(survey,surveyRequest);
        surveyRepository.save(survey);

        return surveyMapper.toSurveyResponse(survey);
    }
}
