package com.sliverorder.domain.menuOptionCategory.entity;

import com.sliverorder.domain.menu.entity.Menu;
import com.sliverorder.domain.optionCategory.entity.OptionCategory;
import com.sliverorder.domain.store.entity.Store;
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
@Table(name="T_OPTION_CATEGORY", uniqueConstraints =
@UniqueConstraint(name = "UNI_MENU_OPTION_CATEGORY", columnNames = {"OPTION_CATEGORY_ID", "MENU_ID"}))
public class MenuOptionCategory {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OPTION_CATEGORY_ID", nullable = false)
    @NotNull
    private OptionCategory optionCategory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID", nullable = false)
    @NotNull
    private Menu menu;
}
