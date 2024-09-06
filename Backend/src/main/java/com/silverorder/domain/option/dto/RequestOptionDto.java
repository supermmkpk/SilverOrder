package com.silverorder.domain.option.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestOptionDto {
    private long optionCategoryId;
    private List<OptionDto> optionDtoList;
}
