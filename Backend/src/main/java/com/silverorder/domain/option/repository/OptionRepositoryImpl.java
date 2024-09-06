package com.silverorder.domain.option.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.silverorder.domain.menu.entity.Menu;
import com.silverorder.domain.option.dto.OptionDto;
import com.silverorder.domain.option.entity.Option;
import com.silverorder.domain.option.entity.OptionCategory;
import com.silverorder.domain.store.entity.Store;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OptionRepositoryImpl implements OptionRepository{

    @PersistenceContext
    private final EntityManager em;
    private final JPAQueryFactory queryFactory;

    @Override
    public OptionCategory saveOptionCategory(Store store, String optionCategoryTitle, int optionType) throws PersistenceException {
        try {
            OptionCategory optionCategory = new OptionCategory(
                    null,
                    store,
                    optionCategoryTitle,
                    optionType
            );

            em.persist(optionCategory);
            em.flush();

            //카테고리 등록 후 id 리턴
            return optionCategory;
        } catch(Exception e){
            throw new PersistenceException("옵션 카테고리 등록 중 에러 발생", e);
        }
    }

    @Override
    public void modifyOptionCategory(OptionCategory optionCategory, String optionCategoryTitle, int optionType) throws PersistenceException {
        try {
            // 카테고리에서 사용중인 옵션 삭제

            // 카테고리 수정

        } catch(Exception e){
            throw new PersistenceException("옵션 카테고리 수정 중 에러 발생", e);
        }
    }

    @Override
    public void saveOption(OptionCategory optionCategory, OptionDto optionDto) throws PersistenceException {
        try {
            Option option = new Option(
                    null,
                    optionCategory,
                    optionDto.getOptionName(),
                    optionDto.getOptionPrice()
            );

            em.persist(option);
            em.flush();
        } catch(Exception e){
            throw new PersistenceException("옵션 등록 중 에러 발생", e);
        }
    }
}
