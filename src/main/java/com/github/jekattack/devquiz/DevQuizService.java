package com.github.jekattack.devquiz;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.desktop.QuitEvent;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DevQuizService {

    private final QuestionRepository questionRepository;
    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public Optional<Question> getQuestionById(String id) {
        return Optional.ofNullable(questionRepository.findQuestionById(id));
    }

    public Question postQuestion(Question newQuestion) {
        return questionRepository.save(newQuestion);
    }
}
