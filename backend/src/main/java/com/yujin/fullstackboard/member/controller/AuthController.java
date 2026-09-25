package com.yujin.fullstackboard.member.controller;

import com.yujin.fullstackboard.member.dto.SignupRequest;
import com.yujin.fullstackboard.member.dto.SignupResponse;
import com.yujin.fullstackboard.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//  - @RestController: JSON API Controller
//  - @RequestMapping: 공통 URL
//  - @PostMapping: POST 요청 처리
//  - @RequestBody: JSON을 DTO로 변환
//  - @Valid: DTO의 이메일·길이 검증 실행
//  - 201 Created: 회원 생성 성공 상태 코드

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<SignupResponse> signup(
            @Valid @RequestBody SignupRequest request
    ) {
        Long memberId = memberService.signup(request);

        SignupResponse response = new SignupResponse(
                memberId,
                "회원가입에 성공했습니다."
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }
}