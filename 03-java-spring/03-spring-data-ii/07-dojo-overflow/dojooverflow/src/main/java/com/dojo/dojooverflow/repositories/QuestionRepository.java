package com.dojo.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.dojo.dojooverflow.models.Question;

public interface QuestionRepository extends CrudRepository<Question, Long>{
	List<Question> findAll();

}
