package com.silverorder.domain.menu.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestMenuDto {
    private long menuCategoryId;
    private String menuName;
    private String simpleName;
    private String menuDesc;
    private int menuStatus;
    private int menuPrice;
    private int recommend;
    private String MenuThumb;
}
