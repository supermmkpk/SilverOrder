package com.silverorder.domain.user.controller;

import com.silverorder.domain.user.dto.*;
import com.silverorder.domain.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 *     사용자 인가 및 인증 컨트롤러 클래스
 * </pre>
 * @author 박봉균
 * @since JDK17 Eclipse Temurin
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
@Tag(name = "Auth", description = "Jwt 토큰 발급 등 회원 인증 인가")
@CrossOrigin("*")
public class AuthController {

    private final UserService userService;

    /**
     * 로그인
     * @param requestDto 요청 DTO
     * @return JwtToken
     */
    @PostMapping("login")
    @Operation(summary = "로그인 요청", description = "회원 이메일과 비밀번호로 로그인을 요청합니다.")
    public ResponseEntity<?> getMemberProfile(@Valid @RequestBody LoginRequestDto requestDto) throws Exception {
            LoginResponseDto responseDto = userService.login(requestDto);
            return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    /**
     * 회원가입
     * @param requestDto 회원가입 요청 DTO
     * @return ResponseEntity
     */
    @Operation(summary = "회원가입", description = "회원의 기본정보를 DB에 영속화합니다.")
    @PostMapping("register")
    public ResponseEntity<?> registerMember(@RequestBody @Valid RegisterRequestDto requestDto) throws Exception {
            userService.register(requestDto);
            return new ResponseEntity<>("회원가입 성공", HttpStatus.CREATED);
    }

}
