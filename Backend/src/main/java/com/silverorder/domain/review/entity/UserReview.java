package com.silverorder.domain.review.entity;

import com.silverorder.domain.order.entity.Order;
import com.silverorder.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_REVIEW")
@IdClass(ReviewId.class)
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID", nullable = false)
    private Long id;

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private Order order; //외래키

    @Column(name = "CONTENT", length = 2000)
    private String content;

    @Column(name = "RATING", nullable = false)
    private int rating;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "USER_ID", nullable = false)
    private User user; //외래키

}


