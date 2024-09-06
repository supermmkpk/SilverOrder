package com.silverorder.domain.manage.service;

import com.silverorder.domain.manage.dto.ManageRequestDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@Service
public class ManageServiceImpl implements ManageService {

    @Value("${external.api.url}")
    private String externalApiUrl;

    public ManageServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final RestTemplate restTemplate;

    @Override
    public String getApiKey(ManageRequestDto requestDto) {
        String url = externalApiUrl +"issuedApiKey";
        return restTemplate.postForObject(url, requestDto, String.class);
    }

    @Override
    public String getApiKeyReissue(ManageRequestDto requestDto) {
        String url = externalApiUrl + "reIssuedApiKey";
        return restTemplate.postForObject(url, requestDto, String.class);
    }

}
