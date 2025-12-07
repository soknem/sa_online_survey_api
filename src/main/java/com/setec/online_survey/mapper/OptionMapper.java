package com.setec.online_survey.mapper;

import com.setec.online_survey.domain.Option;
import com.setec.online_survey.features.option.dto.OptionRequest;
import com.setec.online_survey.features.option.dto.OptionResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OptionMapper {
    Option fromOptionRequest(OptionRequest optionRequest);

    OptionResponse toOptionResponse(Option option);
}
