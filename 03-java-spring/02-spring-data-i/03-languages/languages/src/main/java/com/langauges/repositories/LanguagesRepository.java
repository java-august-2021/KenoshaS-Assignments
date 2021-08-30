package com.langauges.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.languages.models.Languages;

public interface LanguagesRepository extends CrudRepository<Languages, Long>{
	List<Languages> findAll();
}