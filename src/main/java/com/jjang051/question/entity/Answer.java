package com.jjang051.question.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String content;

    private LocalDateTime regDate;

    @ManyToOne
    private Question question;

    @Builder
    public Answer(String content, LocalDateTime regDate, Question question) {
        this.content = content;
        this.regDate = regDate;
        this.question = question;
    }
}
