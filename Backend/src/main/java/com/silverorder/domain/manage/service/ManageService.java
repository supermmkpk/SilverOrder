package com.silverorder.domain.manage.service;

import com.silverorder.domain.manage.dto.ManageRequestDto;

/**
 * 은행 API 서비스
 * @author 채기훈
 * @since JDK17 Eclipse Temurin
 */
public interface ManageService {

    String getApiKey(ManageRequestDto requestDto);
    String getApiKeyReissue(ManageRequestDto requestDto);
}
