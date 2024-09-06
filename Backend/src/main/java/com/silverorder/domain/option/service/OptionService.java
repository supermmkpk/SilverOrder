package com.silverorder.domain.option.service;

import com.silverorder.domain.option.dto.RequestOptionCategoryDto;

/**
 * <pre>
 *      옵션 관리 서비스 인터페이스
 * </pre>
 * @author 노명환
 * @since JDK17
 */
public interface OptionService {
    void saveOptionCategory(RequestOptionCategoryDto requestOptionCategoryDto) throws Exception;
    void modifyOptionCategory(long optionCategoryId, RequestOptionCategoryDto requestOptionCategoryDto) throws Exception;
}
