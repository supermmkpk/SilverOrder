package com.silverorder.domain.manage.service;

import com.silverorder.domain.manage.dto.ManageRequestDto;

public interface ManageService {

    String getApiKey(ManageRequestDto requestDto);
    String getApiKeyReissue(ManageRequestDto requestDto);
}
