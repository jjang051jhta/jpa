package com.jjang051.question.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String content;

    private LocalDateTime regDate;

    @ManyToOne
    //@JoinColumn(name="qid")
    @JoinColumn
    private Question question;

    @Builder
    public Answer(String content, LocalDateTime regDate, Question question) {
        this.content = content;
        this.regDate = regDate;
        this.question = question;
    }
}
