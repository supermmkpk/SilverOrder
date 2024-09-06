package com.silverorder.domain.option.service;

import com.silverorder.domain.option.dto.OptionDto;
import com.silverorder.domain.option.dto.RequestOptionCategoryDto;
import com.silverorder.domain.option.dto.RequestOptionDto;
import com.silverorder.domain.option.entity.OptionCategory;
import com.silverorder.domain.option.repository.OptionCategoryJpaRepository;
import com.silverorder.domain.option.repository.OptionRepository;
import com.silverorder.domain.store.entity.Store;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <pre>
 *      옵션 관리 서비스 구현
 * </pre>
 * @author 노명환
 * @since JDK17
 */
@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OptionServiceImpl implements OptionService{
    private final OptionRepository optionRepository;
    private final OptionCategoryJpaRepository optionCategoryJpaRepository;


    /**
     * 옵션 카테고리 등록
     * @param requestOptionCategoryDto : 옵션 등록 요소
     * @throws Exception
     */
    @Override
    @Transactional
    public void saveOptionCategory(RequestOptionCategoryDto requestOptionCategoryDto) throws Exception {
        //유저 확인 로직

        //가게 확인 로직
        Store store = null;

        //카테고리 등록 및 리턴
        OptionCategory optionCategory = optionRepository.saveOptionCategory(store,
                requestOptionCategoryDto.getOptionCategoryTitle(),
                requestOptionCategoryDto.getOptionType());
        log.info("return optionCategoryId : {}", optionCategory.getId());

        //옵션 카테고리 요청 내 옵션리스트 확인
        RequestOptionDto requestOptionDto =
                requestOptionCategoryDto.getRequestOptionDto();

        // 옵션목록 존재 시
        if(requestOptionDto.getOptionDtoList() != null
                && !requestOptionDto.getOptionDtoList().isEmpty()) {
            for (OptionDto options : requestOptionDto.getOptionDtoList()) {
                //옵션리스트 등록
                optionRepository.saveOption(optionCategory, options);
            }
        }

    }

    @Override
    @Transactional
    public void modifyOptionCategory(long optionCategoryId, RequestOptionCategoryDto requestOptionCategoryDto) throws Exception {
        //유저 확인 로직

        //가게 확인 로직

        //옵션 카테고리 확인 로직
        OptionCategory optionCategory = optionCategoryJpaRepository.findById(optionCategoryId)
                .orElseThrow(() -> new EntityNotFoundException("해당 옵션 카테고리를 찾을 수 없습니다."));

        optionRepository.modifyOptionCategory(optionCategory,
                requestOptionCategoryDto.getOptionCategoryTitle(),
                requestOptionCategoryDto.getOptionType());

        //옵션 카테고리 요청 내 옵션리스트 확인
        RequestOptionDto requestOptionDto =
                requestOptionCategoryDto.getRequestOptionDto();

        // 옵션목록 존재 시
        if(requestOptionDto.getOptionDtoList() != null
                && !requestOptionDto.getOptionDtoList().isEmpty()) {
            for (OptionDto options : requestOptionDto.getOptionDtoList()) {
                //옵션리스트 등록
                optionRepository.saveOption(optionCategory, options);
            }
        }
    }
}
