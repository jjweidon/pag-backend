package com.punsaeng.pag.entity;

import com.punsaeng.pag.entity.keys.ClassroomAssessmentId;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClassroomAssessment extends BaseTime {

    @EmbeddedId
    private ClassroomAssessmentId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("classroomId")
    @JoinColumn(name = "classroom_id", nullable = false)
    private Classroom classroom;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("assessmentId")
    @JoinColumn(name = "assessment_id", nullable = false)
    private Assessment assessment;
} 