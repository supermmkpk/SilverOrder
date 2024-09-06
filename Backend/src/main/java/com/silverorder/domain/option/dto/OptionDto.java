package com.silverorder.domain.option.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OptionDto {
    private Long optionId;
    private String optionName;
    private int optionPrice;
}
