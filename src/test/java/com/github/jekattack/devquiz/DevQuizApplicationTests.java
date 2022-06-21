package com.github.jekattack.devquiz;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DevQuizApplicationTests {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void integrationTest() {

        ResponseEntity<Question[]> response = testRestTemplate.getForEntity("/devQuiz", Question[].class);

        Assertions.assertThat(response.getBody()).hasSize(0);

        Question newQuestion = new Question(null, "What does IO stand for?", "The sound a donkey makes", "High and low", "On and Off", "Small and big", "On and off");

        ResponseEntity<Question> response2 = testRestTemplate.postForEntity("/devQuiz", newQuestion, Question.class);

        Assertions.assertThat(response2.getBody().getId()).isNotBlank();

        Question fetchedNewQuestion = response2.getBody();
        String idOfNewQuestion = response2.getBody().getId();

        ResponseEntity<Question> response3 = testRestTemplate.getForEntity("/devQuiz/" + idOfNewQuestion, Question.class);

        Assertions.assertThat(response3.getBody()).isEqualTo(fetchedNewQuestion);


    }

}
