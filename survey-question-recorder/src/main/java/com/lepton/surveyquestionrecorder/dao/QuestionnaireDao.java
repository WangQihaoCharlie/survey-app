package com.lepton.surveyquestionrecorder.dao;

import com.lepton.surveyquestionrecorder.entity.dto.Questionnaire;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public interface QuestionnaireDao extends MongoRepository<Questionnaire, Long> {
    List<Questionnaire> findByTitle(String title);
}
