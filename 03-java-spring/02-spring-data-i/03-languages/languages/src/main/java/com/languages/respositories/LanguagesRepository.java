package com.languages.respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.languages.models.Languages;

public interface LanguagesRepository extends CrudRepository<Languages, Long>{
	List<Languages> findAll();
}