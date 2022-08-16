package com.sparta.assignment.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Information extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String content;
    public Information(InformationRequestDto RequestDto) {
        this.title = RequestDto.getTitle();
        this.name = RequestDto.getName();
        this.password = RequestDto.getPassword();
        this.content = RequestDto.getContent();
    }
    public void update(InformationRequestDto RequestDto) {
        this.title = RequestDto.getTitle();
        this.name = RequestDto.getName();
        this.password = RequestDto.getPassword();
        this.content = RequestDto.getContent();
    }
}
