package com.silverorder.domain.user.service;

import com.silverorder.domain.user.dto.CustomUserDetails;
import com.silverorder.domain.user.dto.UserDto;
import com.silverorder.global.exception.CustomException;
import com.silverorder.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.silverorder.domain.user.repository.UserRepository;

/**
 * 유저 로그인 Service
 * <pre>
 *     유저 로그인을 위한 UserDetailService
 * </pre>
 *
 * @author 박봉균
 * @since JDK17
 */

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    /**
     * 회원 고유번호로 조회, UserDetails 반환
     *
     * @param id 회원 고유번호
     * @return UserDetails
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        UserDto userDto = userRepository.findByUserId(Long.parseLong(id));

        if (userDto == null) {
            throw new CustomException(ErrorCode.USER_NOT_FOUND);
        }

        return new CustomUserDetails(userDto);
    }
}
