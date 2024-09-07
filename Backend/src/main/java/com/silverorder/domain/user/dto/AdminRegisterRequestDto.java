package com.silverorder.domain.user.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdminRegisterRequestDto extends RegisterRequestDto {
    @NotNull
    public String merchantId;

}
