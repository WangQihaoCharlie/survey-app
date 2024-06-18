package com.lepton.surveyquestionrecorder.service;

import com.lepton.surveyquestionrecorder.entity.dto.Questionnaire;

import java.util.List;

public interface QuestionnaireCRUDService {


    void save(Questionnaire questionnaire);

    Questionnaire findById(Long id);

    List<Questionnaire> findAll();

    void delete(Long id);

    List<Questionnaire> findByQuestionnaireName(String title);

    void editQuestionnaire(Questionnaire questionnaire);

}
