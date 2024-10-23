package com.silverorder.domain.review.repository;

import com.silverorder.domain.order.entity.Order;
import com.silverorder.domain.review.dto.*;
import com.silverorder.domain.review.entity.UserReview;
import com.silverorder.domain.store.entity.Store;
import com.silverorder.domain.user.entity.User;
import jakarta.persistence.PersistenceException;

import java.util.List;

/**
 * <pre>
 *      리뷰 관리 레포지토리 인터페이스
 * </pre>
 * @author 노명환
 * @since JDK17
 */
public interface ReviewRepository {
    /** 가맹점의 리뷰 조회 */
    List<ResponseReviewDto> listUserReview(Store store) throws PersistenceException;
    /** 유저의 작성 리뷰 조회 */
    List<ResponseMyReviewDto> listMyReview(User user) throws PersistenceException;
    /** 리뷰 단건 조회 */
    ResponseReviewDto userReview(Order order) throws PersistenceException;

    void registUserReview(User user, Order order, UserReviewDto userReviewDto) throws PersistenceException;
    void registOwnerReview(UserReview userReview, RequestOwnerReviewDto requestOwnerReviewDto) throws PersistenceException;
}
