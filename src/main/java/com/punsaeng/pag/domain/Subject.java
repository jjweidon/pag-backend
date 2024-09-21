package com.punsaeng.pag.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Subject {
    KOREAN("국어"),
    MATH("수학"),
    ENGLISH("영어"),
    SCIENCE("과학"),
    HISTORY("역사"),
    PHYSICAL_EDUCATION("체육"),
    ART("미술");

    private final String value;

    @JsonCreator
    public static Subject deserializer(String value) {
        for(Subject subject : Subject.values()) {
            if(subject.getValue().equals(value)) {
                return subject;
            }
        }
        return null;
    }

    @JsonValue
    public String serializer() {
        return value;
    }
}