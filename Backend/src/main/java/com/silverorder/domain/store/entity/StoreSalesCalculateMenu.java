package com.silverorder.domain.store.entity;

import com.silverorder.domain.menu.entity.Menu;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

/**
 * <pre>
 *     매출 정산 상세 도메인 클래스
 * </pre>
 *
 * @author 박봉균
 * @since JDK17 Eclipse Temurin
 */

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_PROC_SALES_DETAIL")
public class StoreSalesCalculateMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROC_DETAIL_ID", nullable = false)
    private Long id;

    @Column(name = "MENU_AMOUNT", nullable = false)
    @ColumnDefault("0")
    private Long menuAmount;

    @Column(name = "MENU_SALES", nullable = false)
    private Long menuSales;

    @Column(name = "PURCHASE_AGE", nullable = false)
    private int purchaseAge;

    @Column(name = "INSERT_DATE", nullable = false)
    private LocalDate insertDate;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PROC_ID", nullable = false)
    private StoreSalesCalculate storeSalesCalculate; //외래키

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MENU_ID", nullable = false)
    private Menu menu; //외래키

}
