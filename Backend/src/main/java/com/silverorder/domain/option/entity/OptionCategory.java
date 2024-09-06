package com.silverorder.domain.option.entity;

import com.silverorder.domain.store.entity.Store;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="T_OPTION_CATEGORY")
public class OptionCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OPTION_CATEGORY_ID",nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORE_ID", nullable = false)
    @NotNull
    private Store store;

    @Column(name = "OPTION_CATEGORY_TITLE", length = 20, nullable = false)
    @NotNull
    private String optionCategoryTitle;

    @Column(name = "OPTION_TYPE", nullable = false)
    @NotNull
    private int optionType;
}
