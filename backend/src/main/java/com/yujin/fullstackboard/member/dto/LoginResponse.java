package com.yujin.fullstackboard.member.dto;

public record LoginResponse(
        Long memberId,
        String email,
        String nickname
) {
}
