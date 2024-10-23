package com.silverorder.domain.review.entity;

import com.silverorder.domain.order.entity.Order;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

/**
 * <pre>
 *     사장님 리뷰 도메인 클래스
 * </pre>
 *
 * @author 박봉균
 * @since JDK17 Eclipse Temurin
 */

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "T_OWNER_REVIEW")
public class OwnerReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMMENT_ID", nullable = false)
    private Long id;

    @Column(name = "CONTENT", length = 2000)
    private String content;

    @Column(name = "CREATED_DATE", nullable = false)
    @CreationTimestamp
    private LocalDate createdDate;

    @Column(name = "MODIFIED_DATE", nullable = false)
    @UpdateTimestamp
    private LocalDate modifiedDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "REVIEW_ID", nullable = false)
    private UserReview userReview; //외래키

}
