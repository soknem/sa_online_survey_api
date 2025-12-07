package com.setec.online_survey.features.option;

import com.setec.online_survey.domain.Option;
import com.setec.online_survey.domain.ResponseSession;
import com.setec.online_survey.features.option.dto.OptionRequest;
import com.setec.online_survey.features.option.dto.OptionResponse;
import com.setec.online_survey.mapper.OptionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OptionServiceImpl implements OptionService{

    private OptionRepository optionRepository;
    private OptionMapper optionMapper;
    @Override
    public void createOptions(OptionRequest optionRequest) {

        Option option = optionMapper.fromOptionRequest(optionRequest);

        optionRepository.save(option);

    }

    @Override
    public OptionResponse getOptionByUuid(String uuid) {
        Option option = optionRepository.findOptionByUuid(uuid)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("option = %s has not been found",uuid)));

        return optionMapper.toOptionResponse(option);
    }

    @Override
    public List<OptionResponse> getAllOptions() {
        return optionRepository.findAll().stream().map(optionMapper::toOptionResponse).toList();
    }

    @Override
    public List<OptionResponse> getOptionByQuestionUuid(String questionUuid) {

        return optionRepository.findOptionByQuestionUuid(questionUuid).stream().map(optionMapper::toOptionResponse).toList();

    }

    @Override
    public void deleteOptionByUuid(String uuid) {

        Option option = optionRepository.findOptionByUuid(uuid)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("option = %s has not been found",uuid)));

        optionRepository.delete(option);

    }

    @Override
    public OptionResponse updateOptionByUuid(String uuid, OptionRequest optionRequest) {
        return null;
    }
}
