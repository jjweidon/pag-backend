package com.punsaeng.pag.controller;

import com.punsaeng.pag.dto.*;
import com.punsaeng.pag.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupRequest signupRequest) {
        memberService.signup(signupRequest);
        return ResponseEntity.ok("회원가입이 완료되었습니다.");
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        memberService.login(loginRequest);
        return ResponseEntity.ok("로그인에 성공했습니다.");
    }

    // 프로필 조회
    @GetMapping("/members/{memberId}")
    public ResponseEntity<MemberDto> getProfile(@PathVariable Long memberId) {
        MemberDto memberDto = memberService.getProfile(memberId);
        return ResponseEntity.ok(memberDto);
    }

    // 프로필 수정
    @PutMapping("/members/{memberId}")
    public ResponseEntity<String> updateProfile(@PathVariable Long memberId, @RequestBody MemberDto memberDto) {
        memberService.updateProfile(memberId, memberDto);
        return ResponseEntity.ok("프로필이 수정되었습니다.");
    }
}