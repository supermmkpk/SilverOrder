package com.silverorder.domain.manage.dto;

import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 관리자 API 요청 정보 DTO
 * @author 채기훈
 * @since JDK17
 */
@Getter
@Builder
public class ManageRequestDto {

    @Email
    private String managerId;
}
