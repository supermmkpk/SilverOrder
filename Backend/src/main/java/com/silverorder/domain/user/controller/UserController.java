package com.silverorder.domain.user.controller;

import com.silverorder.domain.user.dto.CustomUserDetails;
import com.silverorder.domain.user.dto.UserDto;
import com.silverorder.domain.user.service.UserService;
import com.silverorder.global.config.security.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <pre>
 *     회원 관리 컨트롤러 클래스
 * </pre>
 *
 * @author 박봉균
 * @since JDK17
 */
@Tag(name = "User", description = "회원 관리")
@RestController
@RequestMapping("/user")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @Operation(summary="회원 정보 조회", description = "회원 고유번호로 회원 조회")
    @GetMapping("/me")
    public ResponseEntity<?> getUser(@RequestParam("id") Long id) throws Exception {
        UserDto userDto = userService.getUserInfo(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @Operation(summary="회원 삭제", description = "회원 고유번호로 회원 삭제")
    @DeleteMapping("/me")
    public ResponseEntity<?> deleteUser(@RequestParam("id") Long id) throws Exception {
        userService.deleteUser(id);
        return new ResponseEntity<>("회원 탈퇴 성공", HttpStatus.OK);
    }

}
