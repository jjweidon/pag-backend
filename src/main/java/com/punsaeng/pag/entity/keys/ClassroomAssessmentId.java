package com.punsaeng.pag.entity.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ClassroomAssessmentId implements Serializable {
    
    @Column(name = "classroom_id")
    private Long classroomId;
    
    @Column(name = "assessment_id")
    private Long assessmentId;
} 