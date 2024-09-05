package com.sliverorder.domain.storeMenuCategory.entity;

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
@Table(name="T_STORE_MENU_CATEGORY")
public class StoreMenuCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MENU_CATEGORY_ID",nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORE_ID", nullable = false)
    @NotNull
    private Store store;

    @Column(name = "MENU_CATEGORY_NAME", length = 20, nullable = false)
    @NotNull
    private String menuCategoryName;
}
