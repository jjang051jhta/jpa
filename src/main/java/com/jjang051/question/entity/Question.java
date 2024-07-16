package com.jjang051.question.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "table_question")
@SequenceGenerator(
                    name = "question_sequence_generator",
                    sequenceName = "question_sequence",
                    initialValue = 1000,
                    allocationSize = 1
)
public class Question {
    // Object 일반 객체
    // Entity를 달면 컬렴명을 가지고 table
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "question_sequence_generator")
    private Integer id;

    //@Column(name = "column_subject", unique = true)
    private String subject;

    private String content;

    private LocalDateTime regDate;

    @Builder
    public Question(String subject, String content, LocalDateTime regDate) {
        this.subject = subject;
        this.content = content;
        this.regDate = regDate;
    }
}
