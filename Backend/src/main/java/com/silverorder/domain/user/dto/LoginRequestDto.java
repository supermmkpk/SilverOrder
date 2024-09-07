package com.silverorder.domain.user.dto;

import lombok.*;

/**
 * 로그인 요청 Dto
 *
 * @author 박봉균
 * @since JDK17 Eclipse Temurin
 */

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginRequestDto {
    private String userEmail;
    private String password;
}
