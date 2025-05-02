package com.punsaeng.pag.entity;

import com.punsaeng.pag.entity.keys.StudentAssessmentId;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudentAssessment extends BaseTime {

    @EmbeddedId
    private StudentAssessmentId id;

    @MapsId("studentId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false)
    private User student;

    @MapsId("assessmentId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "assessment_id", nullable = false)
    private Assessment assessment;

    private String content;
    
    private String file;
    
    private LocalDate submittedAt;
    
    private Integer score;
    
    private String feedback;
} 