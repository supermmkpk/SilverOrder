package com.silverorder.domain.user.service;


import com.silverorder.domain.user.dto.*;
import com.silverorder.domain.user.entity.User;
import com.silverorder.domain.user.repository.UserRepository;
import com.silverorder.global.config.security.JwtUtil;
import com.silverorder.global.exception.CustomException;
import com.silverorder.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <pre>
 *     회원관리 서비스 구현 클래스
 * </pre>
 * @author 박봉균
 * @since JDK17 Eclipse Temurin
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService  {

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    /**
     *  로그인 메서드
     *
     * @param loginRequestDto 로그인 요청 정보
     * @return LoginResponseDto 로그인 응답 정보
     */
    @Override
    public LoginResponseDto login(LoginRequestDto loginRequestDto) {
        String userEmail = loginRequestDto.getUserEmail();
        String userPassword = loginRequestDto.getPassword();

        UserDto userDto = userRepository.findByUserEmail(userEmail);

        if(userDto == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        if(!passwordEncoder.matches(userPassword, userDto.getUserPassword())) {
            throw new CustomException(ErrorCode.WRONG_PASSWORD);
        }

        String accessToken = jwtUtil.createAccessToken(userDto);

        return new LoginResponseDto(userDto, accessToken);
    }

    /**
     * 회원가입 메서드
     *
     * @param registerRequestDto 회원가입 정보 요청
     * @return RegisterResponseDto 회원가입 상태 정보 반환
     */
    @Transactional
    @Override
    public void register(RegisterRequestDto registerRequestDto){

        // 이메일 중복 체크
        if(userRepository.findByUserEmail(registerRequestDto.getUserEmail()) != null){
            throw new CustomException(ErrorCode.DUPLICATE_USEREMAIL);
        }

        //비밀번호 암호화
        String password = registerRequestDto.getUserPassword();
        registerRequestDto.setUserPassword(passwordEncoder.encode(password));

        // Entity 객체 변환
        User user = registerRequestDto.toEntity();

        //영속화
        userRepository.insertUser(user);
    }

    /**
     * 사용자 정보 조회 메서드
     *
     * @param userId 로그인 중인 사용자 정보
     * @return UserInfoDto 사용자 정보 반환
     */
    @Override
    public UserDto getUserInfo(Long userId){
        return userRepository.findByUserId(userId);
    }

    /**
     * 회원 탈퇴 메서드
     *
     * @param userId 로그인 중인 사용자 정보
     */
    @Transactional
    @Override
    public void deleteUser(Long userId) throws Exception {
        userRepository.deleteUser(userId);
    }

}
