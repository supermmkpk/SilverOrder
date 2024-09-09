package com.silverorder.domain.option.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOptionDto {
    private Long optionCategoryId;
    private String optionCategoryTitle;
    private OptionType optionType;
    private List<OptionDto> optionDtoList;

    public ResponseOptionDto(Long optionCategoryId, String optionCategoryTitle,
                             OptionType optionType){
        this.optionCategoryId = optionCategoryId;
        this.optionCategoryTitle = optionCategoryTitle;
        this.optionType = optionType;
        this.optionDtoList = null;
    }
}
