package com.yujin.fullstackboard.member.service;

import com.yujin.fullstackboard.member.dto.SignupRequest;
import com.yujin.fullstackboard.member.entity.Member;
import com.yujin.fullstackboard.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    //회원가입 작업 중 오류가 발생하면 DB 변경 전체를 취소합니다.
    @Transactional
    public Long signup(SignupRequest request) {
        String email = request.email().trim().toLowerCase(Locale.ROOT);
        String nickname = request.nickname().trim();

        if (memberRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        if (memberRepository.existsByNickname(nickname)) {
            throw new IllegalArgumentException("이미 사용 중인 닉네임입니다.");
        }

        //평문 비밀번호를 BCrypt 문자열로 바꿉니다. 같은 비밀번호를 암호화해도 매번 다른 결과가 생성되는 것이 정상입니다.
        String encodedPassword =
                passwordEncoder.encode(request.password());

        Member member = new Member(
                email,
                encodedPassword,
                nickname
        );

        Member savedMember = memberRepository.save(member);

        return savedMember.getId();
    }
}