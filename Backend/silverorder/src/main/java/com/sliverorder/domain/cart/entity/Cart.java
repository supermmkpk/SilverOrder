package com.sliverorder.domain.cart.entity;

import com.sliverorder.domain.menu.entity.Menu;
import com.sliverorder.domain.store.entity.Store;
import com.sliverorder.domain.storeMenuCategory.entity.StoreMenuCategory;
import com.sliverorder.domain.user.entity.User;
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
@Table(name="T_CART")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ID",nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    @NotNull
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STORE_ID", nullable = false)
    @NotNull
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID", nullable = false)
    @NotNull
    private Menu menu;

    @Column(name = "MENU_AMOUNT", nullable = false)
    @ColumnDefault("0")
    @NotNull
    private int menuAmount;

    @Column(name = "CART_PRICE", nullable = false)
    @ColumnDefault("0")
    @NotNull
    private int cartPrice;
}
