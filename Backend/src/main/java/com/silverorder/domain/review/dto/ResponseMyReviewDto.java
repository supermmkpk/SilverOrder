package com.silverorder.domain.review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMyReviewDto {
    private Long reviewId;
    private String content;
    private int rating;
    private Long orderId;
    private Long storeId;
    private String storeName;
    private String reviewThumb;
    private Long commentId;
    private String commentContent;
    private LocalDate CreatedDate;
    private LocalDate modifiedDate;
}
