package com.thoughtworks.training.controller.mapper;


import com.thoughtworks.training.controller.dto.ScreeningResponse;
import com.thoughtworks.training.entity.Screening;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ScreeningMapper {
    public ScreeningResponse toResponse(Screening screening) {
        ScreeningResponse screeningResponse = new ScreeningResponse();
        BeanUtils.copyProperties(screening, screeningResponse);
        screeningResponse.setLanguage(screening.getMovie().getLanguage());
        screeningResponse.setMoviePrice(screening.getMovie().getMoney());
        screeningResponse.setAuditoriumId(1);
        screeningResponse.setAuditoriumName("暂无");
        return screeningResponse;
    }

    public List<ScreeningResponse> toResponse(List<Screening> screenings) {
        return screenings.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
}
