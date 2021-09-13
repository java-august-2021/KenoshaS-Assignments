package com.dojo.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dojo.dojooverflow.models.Answers;
import com.dojo.dojooverflow.models.NewQuestion;
import com.dojo.dojooverflow.models.Question;
import com.dojo.dojooverflow.models.Tags;
import com.dojo.dojooverflow.repositories.AnswerRepository;
import com.dojo.dojooverflow.repositories.QuestionRepository;
import com.dojo.dojooverflow.repositories.TagRepository;

@Service

public class ApplicationService {
	private QuestionRepository qRepo;
	private TagRepository tRepo;
	private AnswerRepository aRepo;
	public ApplicationService(QuestionRepository qRepo, AnswerRepository aRepo, TagRepository tRepo) {
		this.qRepo = qRepo;
		this.tRepo = tRepo;
		this.aRepo = aRepo;
	}
	public List<Question> getQuestions() {
		return this.qRepo.findAll();
	}
	public Question getQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	public void createQuestion(NewQuestion question) {
		// TODO: make a real question here
		List<Tags> questionsTags = new ArrayList<Tags>();
		for(String subject: question.splitTags()) {
			Tags tag = this.tRepo.findBySubject(subject).orElse(null);
			if(tag == null) {
				tag = new Tags(subject);
				this.tRepo.save(tag);
			}
			// prevent dupe tags
			if(!questionsTags.contains(tag))
				questionsTags.add(tag);
		}
		Question newQuestion = new Question(question.getQuestion(), questionsTags);
		this.qRepo.save(newQuestion);
	}
	public Answers createAnswer(Answers answer) {
		return this.aRepo.save(answer);
	}

}
