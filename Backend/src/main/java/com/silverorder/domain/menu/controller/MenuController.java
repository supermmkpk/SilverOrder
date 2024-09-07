package com.silverorder.domain.menu.controller;

import com.silverorder.domain.menu.dto.RequestMenuCategoryDto;
import com.silverorder.domain.menu.dto.RequestMenuDto;
import com.silverorder.domain.menu.service.MenuService;
import com.silverorder.domain.option.dto.RequestOptionCategoryDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 *     메뉴 관리 컨트롤러 클래스
 * </pre>
 * @author 노명환
 * @since JDK17
 */

@Tag(name = "Menu", description = "옵션 관리")
@RestController
@RequestMapping("/menu")
@CrossOrigin("*")
@RequiredArgsConstructor
public class MenuController {
    private final MenuService menuService;

    @Operation(summary = "메뉴 카테고리 등록", description="가게에서 사용할 메뉴의 카테고리를 등록합니다.")
    @PostMapping("/category")
    public ResponseEntity<?> registMenuCategory (
            @RequestBody @Valid RequestMenuCategoryDto requestMenuCategoryDto
            //@AuthenticationPrincipal CustomUserDetails userDetails
    ) throws Exception {
        //auth로직 구현 후 주석 해제
        //int userId = userDetails.getUser().getUserId();
        menuService.saveMenuCategory(requestMenuCategoryDto);
        return new ResponseEntity<>("메뉴 카테고리 등록 완료", HttpStatus.OK);
    }

    @Operation(summary = "메뉴 등록", description="가게에서 판매할 메뉴를 등록합니다.")
    @PostMapping("")
    public ResponseEntity<?> registMenu(
            @RequestBody @Valid RequestMenuDto requestMenuDto
            //@AuthenticationPrincipal CustomUserDetails userDetails
    ) throws Exception {
        //auth로직 구현 후 주석 해제
        //int userId = userDetails.getUser().getUserId();
        menuService.saveMenu(requestMenuDto);
        return new ResponseEntity<>("메뉴 등록 완료", HttpStatus.OK);
    }
}
