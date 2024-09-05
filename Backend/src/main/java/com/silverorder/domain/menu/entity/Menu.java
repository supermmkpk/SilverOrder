package com.silverorder.domain.menu.entity;

import com.silverorder.domain.storeMenuCategory.entity.StoreMenuCategory;
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
@Table(name="T_MENU")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_ID",nullable = false)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_CATEGORY_ID", nullable = false)
    @NotNull
    private StoreMenuCategory storeMenuCategory;

    @Column(name = "MENU_NAME", length = 30, nullable = false)
    @NotNull
    private String menuName;

    @Column(name = "SIMPLE_NAME", length = 20, nullable = false)
    @NotNull
    private String simpleName;

    @Column(name = "MENU_DESC", length = 100)
    private String menuDesc;

    @Column(name = "MENU_STATUS", length = 4, nullable = false)
    @NotNull
    private String menuStatus;

    @Column(name = "MENU_PRICE", nullable = false)
    @ColumnDefault("0")
    @NotNull
    private int menuPrice;

    @Column(name = "RECOMMEND", nullable = false)
    @ColumnDefault("0")
    @NotNull
    private int recommend;
}
