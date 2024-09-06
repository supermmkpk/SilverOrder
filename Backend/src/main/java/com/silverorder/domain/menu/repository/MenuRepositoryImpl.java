package com.silverorder.domain.menu.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.silverorder.domain.menu.dto.RequestMenuCategoryDto;
import com.silverorder.domain.menu.dto.RequestMenuDto;
import com.silverorder.domain.menu.entity.Menu;
import com.silverorder.domain.store.entity.Store;
import com.silverorder.domain.store.entity.StoreMenuCategory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * <pre>
 *      메뉴 관리 레포지토리 구현
 * </pre>
 * @author 노명환
 * @since JDK17
 */
@Repository
@RequiredArgsConstructor
public class MenuRepositoryImpl implements MenuRepository{

    @PersistenceContext
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    @Override
    public long saveMenu(StoreMenuCategory storeMenuCategory, RequestMenuDto requestMenuDto) throws PersistenceException {
        try {
            Menu menu = new Menu(
                    null,
                    storeMenuCategory,
                    requestMenuDto.getMenuName(),
                    requestMenuDto.getSimpleName(),
                    requestMenuDto.getMenuDesc(),
                    requestMenuDto.getMenuStatus(),
                    requestMenuDto.getMenuPrice(),
                    requestMenuDto.getRecommend(),
                    requestMenuDto.getMenuThumb()
            );

            em.persist(menu);
            em.flush();

            return menu.getId();
        } catch(Exception e){
            throw new PersistenceException("메뉴 등록 중 에러 발생", e);
        }
    }
}
