package com.punsaeng.pag.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/{memberId}/assessments")
    public ResponseEntity<List<AssessmentResponse>> getMemberAssessments(@PathVariable Long memberId) {
        List<AssessmentResponse> assessments = memberService.getAssessmentsForMember(memberId);
        log.info("Response GET assessments for member: {}", assessments);
        return ResponseEntity.ok(assessments);
    }

    @GetMapping("/{memberId}/assessments/{assessmentId}/results")
    public ResponseEntity<AssessmentResultResponse> getMemberAssessmentResult(
            @PathVariable Long memberId,
            @PathVariable Long assessmentId) {
        AssessmentResultResponse result = memberService.getAssessmentResult(memberId, assessmentId);
        log.info("Response GET assessment result: {}", result);
        return ResponseEntity.ok(result);
    }
}
