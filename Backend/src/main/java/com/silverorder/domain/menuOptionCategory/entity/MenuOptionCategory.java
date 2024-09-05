package com.silverorder.domain.menuOptionCategory.entity;

import com.silverorder.domain.menu.entity.Menu;
import com.silverorder.domain.optionCategory.entity.OptionCategory;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_OPTION_CATEGORY", uniqueConstraints =
@UniqueConstraint(name = "UNI_MENU_OPTION_CATEGORY", columnNames = {"OPTION_CATEGORY_ID", "MENU_ID"}))
public class MenuOptionCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_OPTION_CATEGORY_ID", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OPTION_CATEGORY_ID", nullable = false)
    @NotNull
    private OptionCategory optionCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID", nullable = false)
    @NotNull
    private Menu menu;
}
