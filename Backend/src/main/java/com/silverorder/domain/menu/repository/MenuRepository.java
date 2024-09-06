package com.silverorder.domain.menu.repository;

import com.silverorder.domain.menu.dto.RequestMenuCategoryDto;
import com.silverorder.domain.menu.dto.RequestMenuDto;
import com.silverorder.domain.store.entity.Store;
import com.silverorder.domain.store.entity.StoreMenuCategory;
import jakarta.persistence.PersistenceException;

public interface MenuRepository {
    long saveMenu(StoreMenuCategory storeMenuCategory, RequestMenuDto requestMenuDto) throws PersistenceException;

    //void saveStoreMenuCategory(Store store, String menuCategoryName) throws PersistenceException;
}
