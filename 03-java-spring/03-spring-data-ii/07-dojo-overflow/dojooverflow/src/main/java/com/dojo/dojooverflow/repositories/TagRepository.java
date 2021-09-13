package com.dojo.dojooverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.dojo.dojooverflow.models.Tags;

public interface TagRepository extends CrudRepository<Tags, Long> {
	List<Tags> findAll();
	Optional<Tags> findBySubject(String subject);
}
