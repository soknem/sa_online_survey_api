package com.setec.online_survey.features.option;

import com.setec.online_survey.features.option.dto.OptionRequest;
import com.setec.online_survey.features.option.dto.OptionResponse;

import java.util.List;

public interface OptionService {

    void createOptions(OptionRequest optionRequest);

    OptionResponse getOptionByUuid(String uuid);

    List<OptionResponse> getAllOptions();

    List<OptionResponse> getOptionByQuestionUuid(String questionUuid);

    void deleteOptionByUuid(String uuid);

    OptionResponse updateOptionByUuid(String uuid,OptionRequest optionRequest);
}
