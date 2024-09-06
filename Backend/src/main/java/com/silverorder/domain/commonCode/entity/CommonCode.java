package com.silverorder.domain.commonCode.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="T_COMMON_CODE")
public class CommonCode {
    @Id
    @Column(name = "CODE_ID",nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID", nullable = false)
    @NotNull
    private CodeGroup codeGroup;

    @Column(name = "CODE_VALUE", length = 50)
    private String usedColumn;

    @Column(name = "INSERT_DATE", nullable = false)
    @NotNull
    private LocalDateTime insertDate;
}
