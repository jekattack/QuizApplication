package com.github.jekattack.devquiz;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devQuiz")
@RequiredArgsConstructor
public class DevQuizController {

    private final DevQuizService devQuizService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Question> getAllQuestions() {
        return devQuizService.getAllQuestions();
    }

    @GetMapping("/{id}")
    @ResponseStatus
    public ResponseEntity<Question> getQuestionById(@PathVariable String id){
        return ResponseEntity.of(devQuizService.getQuestionById(id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Question postQuestion(@RequestBody Question newQuestion){
        return devQuizService.postQuestion(newQuestion);
    }




}
