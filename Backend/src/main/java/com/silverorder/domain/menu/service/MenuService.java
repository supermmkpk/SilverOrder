package com.silverorder.domain.menu.service;

import com.silverorder.domain.menu.dto.RequestMenuCategoryDto;
import com.silverorder.domain.menu.dto.RequestMenuDto;

/**
 * <pre>
 *      메뉴 관리 서비스 인터페이스
 * </pre>
 * @author 노명환
 * @since JDK17
 */
public interface MenuService {
    void saveMenu(RequestMenuDto requestMenuDto) throws Exception;

    void saveMenuCategory(RequestMenuCategoryDto requestMenuCategoryDto) throws Exception;
}
