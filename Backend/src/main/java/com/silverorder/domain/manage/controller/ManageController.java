package com.silverorder.domain.manage.controller;

import com.silverorder.domain.manage.dto.ManageRequestDto;
import com.silverorder.domain.manage.service.ManageServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 매장 - 은행 관리 컨트롤러 클래스
 * @author 채기훈
 * @since JDK17
 */
@Controller
@Tag(name = "Manage", description = "매장 - 은행 관리")
@RequiredArgsConstructor
public class ManageController {

    private final ManageServiceImpl manageService;

    @Operation(
            summary = "은행 API KEY 요청",
            description = "은행 이용을 위한 API KEY를 받아옵니다"
    )
    @GetMapping("/apikey")
    public ResponseEntity<?> issuedApiKey(ManageRequestDto manageRequestDto) {

        String apiKey = manageService.getApiKey(manageRequestDto);
        return ResponseEntity.ok(apiKey);
    }

    @Operation(
            summary = "은행 API KEY 재발급",
            description = "API KEY 재발급을 요청합니다. 기존의 KEY는 폐기됩니다."
    )
    @GetMapping("/apikey/reissue")
    public ResponseEntity<?> issuedApiKeyReissue(ManageRequestDto manageRequestDto) {
        String apiKey = manageService.getApiKeyReissue(manageRequestDto);
        return ResponseEntity.ok(apiKey);
    }

}
