package com.punsaeng.pag.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class MemberDto {
    private String name;
    private String className;
    private int grade;

    // @Builder 사용 시 필드들이 초기화될 수 있도록 생성자를 명시해줍니다.
    public MemberDto(String name, String className, int grade) {
        this.name = name;
        this.className = className;
        this.grade = grade;
    }
}