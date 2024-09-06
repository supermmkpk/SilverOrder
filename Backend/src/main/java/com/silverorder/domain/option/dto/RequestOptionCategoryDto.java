package com.silverorder.domain.option.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestOptionCategoryDto {
    private long storeId;
    private String optionCategoryTitle;
    private int optionType;
    private RequestOptionDto requestOptionDto;
}
