package com.github.jekattack.devquiz;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question, String> {

    Question findQuestionById(String input);

}

