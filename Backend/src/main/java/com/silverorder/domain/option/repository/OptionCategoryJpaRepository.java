package com.silverorder.domain.option.repository;

import com.silverorder.domain.option.entity.OptionCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionCategoryJpaRepository extends JpaRepository<OptionCategory, Long> {
}
