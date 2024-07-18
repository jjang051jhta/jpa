package com.jjang051.question.service;

import com.jjang051.question.dto.CustomUserDetails;
import com.jjang051.question.entity.Member;
import com.jjang051.question.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        log.info("로그인시도를 하면 여기로 들어온다");
        log.info("userId==={}",userId);
        Optional<Member> optionalMember = memberRepository.findByUserId(userId);
        if(optionalMember.isPresent()) {
            //6개말고 다른것들도 쓸 수 있게 되었다...
            return new CustomUserDetails(optionalMember.get());
        }
        throw new UsernameNotFoundException("아이디 패스워드 확인해 주세요.");
    }
}
