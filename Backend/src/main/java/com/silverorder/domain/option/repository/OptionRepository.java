package com.silverorder.domain.option.repository;

import com.silverorder.domain.option.dto.OptionDto;
import com.silverorder.domain.option.entity.OptionCategory;
import com.silverorder.domain.store.entity.Store;
import jakarta.persistence.PersistenceException;

public interface OptionRepository {
    OptionCategory saveOptionCategory(Store store, String optionCategoryTitle, int optionType) throws PersistenceException;

    void modifyOptionCategory(OptionCategory optionCategory, String optionCategoryTitle, int optionType) throws PersistenceException;

    void saveOption(OptionCategory optionCategory, OptionDto optionDto) throws PersistenceException;
}
