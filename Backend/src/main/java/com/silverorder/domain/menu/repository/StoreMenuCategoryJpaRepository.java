package com.silverorder.domain.menu.repository;

import com.silverorder.domain.store.entity.StoreMenuCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreMenuCategoryJpaRepository extends JpaRepository<StoreMenuCategory, Long> {
}
