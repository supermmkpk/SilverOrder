package com.silverorder.domain.user.dto;

import com.silverorder.domain.user.entity.User;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminRegisterRequestDto extends RegisterRequestDto {
    @NotNull
    public Long storeId;

    public User toEntity() {
        return super.toEntity();
    }
}
