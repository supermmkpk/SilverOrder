package com.silverorder.domain.option.service;

import com.silverorder.domain.option.dto.RequestOptionCategoryDto;
import com.silverorder.domain.option.dto.ResponseOptionDto;

import java.util.List;

/**
 * <pre>
 *      옵션 관리 서비스 인터페이스
 * </pre>
 * @author 노명환
 * @since JDK17
 */
public interface OptionService {
    void saveOptionCategory(long userId, RequestOptionCategoryDto requestOptionCategoryDto) throws Exception;
    void modifyOptionCategory(long userId, long optionCategoryId, RequestOptionCategoryDto requestOptionCategoryDto) throws Exception;
    void deleteOptionCategory(long userId, long optionCategoryId) throws Exception;

    List<ResponseOptionDto> listOptionCategory(long storeId) throws Exception;
    ResponseOptionDto detailOptionCategory(long optionCategoryId) throws Exception;
}
