package com.jjang051.question;

import com.jjang051.question.entity.Question;
import com.jjang051.question.repository.QuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class QuestionTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    public void insertQuestionTest() {
        Question question01 = new Question();
        question01.setSubject("트럼프가 대통령이 될까요?");
        question01.setContent("트럼프가 대통령이 될까요? 되면 어떻게 될까요?");
        question01.setRegDate(LocalDateTime.now());
        questionRepository.save(question01);


        Question question02 = new Question();
        question02.setSubject("바이든은 어떻게 될까요?");
        question02.setContent("바이든은 떨어질까요?");
        question02.setRegDate(LocalDateTime.now());
        questionRepository.save(question02);



        Question question03 = new Question();
        question03.setSubject("바이엘은 어떻게 될까요?");
        question03.setContent("바이엘은 떨어질까요?");
        question03.setRegDate(LocalDateTime.now());
        questionRepository.save(question03);




        //java method가지고 db입출력이 가능함...

    }

    @Test
    public void getAllTest() {
        List<Question> list = questionRepository.findAll();
        Assertions.assertEquals(2, list.size());
    }

    @Test
    public void getTitle() {
        List<Question> list = questionRepository.findAll();
        Question question01 = list.get(0);
        Assertions.assertEquals("트럼프가 대통령이 될까요?",
                question01.getSubject());
    }

    @Test
    public void findByIdTest() {
        Optional<Question> optionalQuestion = questionRepository.findById(1);
        if (optionalQuestion.isPresent()) {
            Question question01 = optionalQuestion.get();
            Assertions.assertEquals(question01.getSubject(), "바이든은 어떻게 될까요?");
        }
    }

    @Test
    public void findBySubjectTest() {
        Question question = questionRepository.findBySubject("바이든은 어떻게 될까요?");
        Assertions.assertEquals(question.getContent(), "바이든은 떨어질까요?");
    }


    @Test
    public void findBySubjectAndContentTest() {
        Question question = questionRepository.findBySubjectAndContent(
                "바이든은 어떻게 될까요?","바이든은 떨어질까요?");
        Assertions.assertEquals(question.getContent(), "바이든은 떨어질까요?");
        Assertions.assertEquals(question.getSubject(), "바이든은 어떻게 될까요?");
    }


    @Test
    public void findBySubjectLikeTest() {
        List<Question> questionList = questionRepository.findBySubjectLike("%바이%");
        //List<Question> questionList = questionRepository.findBySubjectLike("바이든은");
        Assertions.assertEquals(questionList.size(), 2);
    }

    @Test
    public void updateTest() {
        Optional<Question> optionalQuestion = questionRepository.findById(1);
        if(optionalQuestion.isPresent()) {
            Question question = optionalQuestion.get();
            question.setSubject("오바마는 잘 지내나?");
            questionRepository.save(question);
        }
        //jpa는 update를 save로 사용하면 된다.
        //만약 처음 입력되는 상태라면 insert를 진행하고
        //찾아서 내용을 바꾸면 update 쿼리를 날린다.
    }
}
