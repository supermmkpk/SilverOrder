package com.sliverorder.domain.cartOption.entity;

import com.sliverorder.domain.cart.entity.Cart;
import com.sliverorder.domain.menuOptionCategory.entity.MenuOptionCategory;
import com.sliverorder.domain.option.entity.Option;
import com.sliverorder.domain.storeMenuCategory.entity.StoreMenuCategory;
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
@Table(name="T_CART_OPTION")
public class CartOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_OPTION_ID",nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CART_ID", nullable = false)
    @NotNull
    private Cart cart;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OPTION_ID", nullable = false)
    @NotNull
    private Option option;
}
