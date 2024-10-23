package com.silverorder.domain.option.repository;

import com.silverorder.domain.option.dto.OptionDto;
import com.silverorder.domain.option.dto.OptionType;
import com.silverorder.domain.option.dto.ResponseOptionDto;
import com.silverorder.domain.option.entity.OptionCategory;
import com.silverorder.domain.store.entity.Store;
import jakarta.persistence.PersistenceException;

import java.util.List;

public interface OptionRepository {
    OptionCategory saveOptionCategory(Store store, String optionCategoryTitle, OptionType optionType) throws PersistenceException;
    void modifyOptionCategory(OptionCategory modOptionCategory, String optionCategoryTitle, OptionType optionType) throws PersistenceException;
    void deleteOptionCategory(OptionCategory delOptionCategory) throws PersistenceException;
    void saveOption(OptionCategory optionCategory, List<OptionDto> optionDtoList) throws PersistenceException;

    List<ResponseOptionDto> listOptionCategory(Store store) throws PersistenceException;
    List<OptionDto> detailOptionCategory(OptionCategory optionCategory) throws PersistenceException;
}
