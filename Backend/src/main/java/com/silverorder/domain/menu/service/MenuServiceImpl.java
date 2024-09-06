package com.silverorder.domain.menu.service;

import com.silverorder.domain.menu.dto.RequestMenuCategoryDto;
import com.silverorder.domain.menu.dto.RequestMenuDto;
import com.silverorder.domain.menu.entity.Menu;
import com.silverorder.domain.menu.repository.MenuJpaRepository;
import com.silverorder.domain.menu.repository.MenuRepository;
import com.silverorder.domain.menu.repository.StoreMenuCategoryJpaRepository;
import com.silverorder.domain.option.dto.OptionDto;
import com.silverorder.domain.option.entity.OptionCategory;
import com.silverorder.domain.option.repository.OptionCategoryJpaRepository;
import com.silverorder.domain.store.entity.Store;
import com.silverorder.domain.store.entity.StoreMenuCategory;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 *      메뉴 관리 서비스 구현
 * </pre>
 * @author 노명환
 * @since JDK17
 */
@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService{
    private final MenuRepository menuRepository;
    private final MenuJpaRepository menuJpaRepository;
    private final StoreMenuCategoryJpaRepository storeMenuCategoryJpaRepository;
    private final OptionCategoryJpaRepository optionCategoryJpaRepository;


    @Override
    @Transactional
    public void saveMenu(RequestMenuDto requestMenuDto) throws Exception {
        //유저 확인 로직

        //가맹점 확인 로직
        //Store store = null;

        //메뉴 카테고리 확인 로직
        StoreMenuCategory storeMenuCategory = storeMenuCategoryJpaRepository.findById(
                requestMenuDto.getMenuCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("해당 메뉴 카테고리를 찾을 수 없습니다."));

        //메뉴 등록
        Menu menu = menuRepository.saveMenu(storeMenuCategory, requestMenuDto);
        log.info("return menuId : {}", menu.getId());

        //사용 옵션 확인
        long[] optionCategoryIds = requestMenuDto.getUseOptionCategory();

        //사용 옵션 존재 시
        if(optionCategoryIds != null
                && optionCategoryIds.length >= 1) {
            for (long optionCategoryId : optionCategoryIds) {
                OptionCategory optionCategory = optionCategoryJpaRepository.findById(
                        optionCategoryId)
                        .orElseThrow(() -> new EntityNotFoundException("해당 옵션 카테고리를 찾을 수 없습니다."));
                //메뉴의 사용 옵션 등록
                menuRepository.saveMenuOptionCategory(menu, optionCategory);
            }
        }
    }

    @Override
    @Transactional
    public void saveMenuCategory(RequestMenuCategoryDto requestMenuCategoryDto) throws Exception {
        //가맹점 확인 로직
        Store store = null;

        //메뉴 카테고리 등록
        menuRepository.saveStoreMenuCategory(store, requestMenuCategoryDto.getMenuCategoryName());
    }
}
