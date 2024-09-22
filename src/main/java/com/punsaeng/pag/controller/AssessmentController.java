package com.punsaeng.pag.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/assessments")
public class AssessmentController {

    private final AssessmentService assessmentService;

    @PostMapping
    public ResponseEntity<AssessmentResponse> createAssessment(@RequestBody AssessmentRequest request) {
        AssessmentResponse assessment = assessmentService.createAssessment(request);
        log.info("Response POST create assessment: {}", assessment);
        return ResponseEntity.status(HttpStatus.CREATED).body(assessment);
    }

    @PutMapping("/{assessmentId}")
    public ResponseEntity<AssessmentResponse> updateAssessment(
            @PathVariable Long assessmentId,
            @RequestBody AssessmentRequest request) {
        AssessmentResponse updatedAssessment = assessmentService.updateAssessment(assessmentId, request);
        log.info("Response PUT update assessment: {}", updatedAssessment);
        return ResponseEntity.ok(updatedAssessment);
    }

    @DeleteMapping("/{assessmentId}")
    public ResponseEntity<Void> deleteAssessment(@PathVariable Long assessmentId) {
        assessmentService.deleteAssessment(assessmentId);
        log.info("Response DELETE assessment with id: {}", assessmentId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{assessmentId}")
    public ResponseEntity<AssessmentResponse> getAssessment(@PathVariable Long assessmentId) {
        AssessmentResponse assessment = assessmentService.getAssessment(assessmentId);
        log.info("Response GET assessment: {}", assessment);
        return ResponseEntity.ok(assessment);
    }

    @PostMapping("/results")
    public ResponseEntity<AssessmentResultResponse> createAssessmentResult(@RequestBody AssessmentResultRequest request) {
        AssessmentResultResponse result = assessmentService.createAssessmentResult(request);
        log.info("Response POST create assessment result: {}", result);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
