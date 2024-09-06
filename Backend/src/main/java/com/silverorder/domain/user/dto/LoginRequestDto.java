package com.silverorder.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 로그인 요청 Dto
 * @author 채기훈
 * @since JDK17
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDto {
    private String userEmail;
    private String password;
}
