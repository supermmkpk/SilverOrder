package com.silverorder.domain.option.entity;

import com.silverorder.domain.optionCategory.entity.OptionCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="T_OPTION")
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_ID",nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OPTION_CATEGORY_ID", nullable = false)
    @NotNull
    private OptionCategory optionCategory;

    @Column(name = "OPTION_NAME", length = 50, nullable = false)
    @NotNull
    private String optionName;

    @Column(name = "OPTION_PRICE", nullable = false)
    @ColumnDefault("0")
    @NotNull
    private int optionPrice;
}
