package com.punsaeng.pag.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    private String name;

    private String email;

    private String password;

    private Role role;

    // 프로필 수정 메서드
    public void updateProfile(String name, Classroom classroom) {
        this.name = name;
        this.classroom = classroom;
    }
}