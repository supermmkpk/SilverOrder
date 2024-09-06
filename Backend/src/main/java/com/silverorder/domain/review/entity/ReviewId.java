package com.silverorder.domain.review.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <pre>
 *     리뷰 다중키 칼럼 클래스
 * </pre>
 *
 * @author 박봉균
 * @since JDK17 Eclipse Temurin
 */
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class ReviewId implements Serializable {
    private Long id;
    private Long order;
}
