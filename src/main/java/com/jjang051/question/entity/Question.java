package com.jjang051.question.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

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

    //연관관계  질문 하나에 답변이 여러게 달릴 수 있음   1:n
    //mappedBy  연관관계의 주인 설정
    //foreign key

    @OneToMany(mappedBy = "question")
    private List<Answer> answer;  // foreign_key

    @Builder
    public Question(String subject, String content, LocalDateTime regDate) {
        this.subject = subject;
        this.content = content;
        this.regDate = regDate;
    }
}
