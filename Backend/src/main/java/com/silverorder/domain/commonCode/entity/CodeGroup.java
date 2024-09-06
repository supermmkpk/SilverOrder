package com.silverorder.domain.commonCode.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="T_CODE_GROUP")
public class CodeGroup {
    @Id
    @Column(name = "GROUP_ID",nullable = false)
    private Long id;

    @Column(name = "GROUP_NAME", length = 50, nullable = false)
    @NotNull
    private String groupName;

    @Column(name = "USED_COLUMN", length = 50)
    private String usedColumn;

    @Column(name = "INSERT_DATE", nullable = false)
    @NotNull
    private LocalDateTime insertDate;
}
