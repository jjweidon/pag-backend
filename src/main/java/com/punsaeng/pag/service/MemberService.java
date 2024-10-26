package com.punsaeng.pag.service;

import com.punsaeng.pag.domain.Classroom;
import com.punsaeng.pag.domain.Member;
import com.punsaeng.pag.domain.Role;
import com.punsaeng.pag.dto.LoginRequest;
import com.punsaeng.pag.dto.MemberDto;
import com.punsaeng.pag.dto.SignupRequest;
import com.punsaeng.pag.repository.ClassroomRepository;
import com.punsaeng.pag.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final ClassroomRepository classroomRepository;

    // 회원가입 메서드
    public void signup(SignupRequest signupRequest) {
        Member newMember = Member.builder()
                .email(signupRequest.getEmail())
                .password(signupRequest.getPassword())
                .role(Role.STUDENT)  // 기본 사용자 권한 설정
                .build();
        memberRepository.save(newMember);
    }

    // 로그인 메서드
    public void login(LoginRequest loginRequest) {
        Member member = memberRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("해당 이메일을 가진 회원이 없습니다."));

        // 비밀번호 검증
        if (!loginRequest.getPassword().equals(member.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }

    // 프로필 조회 메서드
    public MemberDto getProfile(Long memberId) {
        // 회원 찾기
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 회원이 없습니다."));

        // Member를 MemberDto로 변환
        return MemberDto.builder()
                .name(member.getName())
                .className(member.getClassroom().getName())
                .grade(member.getClassroom().getGrade())
                .build();
    }

    // 프로필 수정 메서드
    public void updateProfile(Long memberId, MemberDto memberDto) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("해당 ID를 가진 회원이 없습니다."));

        // 요청으로 받은 className과 classGrade로 Classroom 찾기
        Classroom classroom = classroomRepository.findByNameAndGrade(memberDto.getClassName(), memberDto.getGrade())
                .orElseThrow(() -> new IllegalArgumentException("해당 반 정보가 없습니다."));


        member.updateProfile(memberDto.getName(), classroom);
    }
}