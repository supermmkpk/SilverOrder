package com.silverorder.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserReviewDto {
    private String content;
    private int rating;
    private Long orderId;
    private String reviewThumb;
}
