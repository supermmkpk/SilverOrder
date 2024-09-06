package com.silverorder.domain.option.controller;

import com.silverorder.domain.option.dto.RequestOptionCategoryDto;
import com.silverorder.domain.option.service.OptionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 *     옵션 관리 컨트롤러 클래스
 * </pre>
 * @author 노명환
 * @since JDK17
 */

@Tag(name = "Option", description = "옵션 관리")
@RestController
@RequestMapping("/optioncategory")
@CrossOrigin("*")
@RequiredArgsConstructor
public class OptionController {
    private final OptionService optionService;

    @Operation(summary = "옵션 카테고리 등록", description="가게에서 사용할 옵션 카테고리를 등록합니다.")
    @PostMapping("")
    public ResponseEntity<?> registOptionCategory (
            @RequestBody @Valid RequestOptionCategoryDto requestOptionCategoryDto
            //@AuthenticationPrincipal CustomUserDetails userDetails
    ) throws Exception {
        //auth로직 구현 후 주석 해제
        //int userId = userDetails.getUser().getUserId();
        optionService.saveOptionCategory(requestOptionCategoryDto);
        return new ResponseEntity<>("성적 카테고리 등록 완료", HttpStatus.OK);
    }
}
