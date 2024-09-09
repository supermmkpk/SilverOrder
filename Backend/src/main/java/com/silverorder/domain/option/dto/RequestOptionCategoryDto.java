package com.silverorder.domain.option.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestOptionCategoryDto {
    private Long storeId;
    private String optionCategoryTitle;
    private OptionType optionType;
    private List<OptionDto> optionDtoList;
}
