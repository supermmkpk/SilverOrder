package com.silverorder.domain.user.dto;

import com.silverorder.domain.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * <pre>
 *     회원 DTO 클래스
 * </pre>
 * @author 박봉균
 * @since JDK17 Eclipse Temurin
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long userId;

    private String userEmail;

    private String userPassword;

    private int userStatus;

    private LocalDateTime userJoinDate;

    private LocalDateTime userUpdateDate;

    /**
     * DTO를 회원 엔터티로 변환하는 함수
     * @return User
     */
    public User toEntity() {
        return User.builder()
                .id(this.userId)
                .userEmail(this.userEmail)
                .userPassword(this.userPassword)
                .userJoinDate(this.userJoinDate)
                .userStatus(this.userStatus)
                .userUpdateDate(this.userUpdateDate)
                .build();
    }

}
