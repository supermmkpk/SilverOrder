package com.silverorder.domain.menu.dto;

import com.silverorder.domain.option.dto.RequestOptionDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestMenuCategoryDto {
    private Long storeId;
    private String menuCategoryName;
}
