package com.silverorder.domain.order.dto;

import com.silverorder.domain.menu.entity.Menu;
import com.silverorder.domain.order.entity.Order;
import com.silverorder.domain.order.entity.OrderMenu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderMenuDto {
    private Long menuId;
    private String menuName;
    private int menuAmount;
    private Long menuPrice;
    private List<OrderOptionDto> optionList;

    public OrderMenu toEntity(Menu menu, Order order) {
        return OrderMenu.builder()
                .menuAmount(this.menuAmount)
                .menuPrice(this.menuPrice)
                .menu(menu)
                .order(order)
                .build();
    }
}
