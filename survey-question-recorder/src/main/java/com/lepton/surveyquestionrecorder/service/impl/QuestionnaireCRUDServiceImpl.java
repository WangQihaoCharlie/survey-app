package com.lepton.surveyquestionrecorder.service.impl;

import com.lepton.surveyquestionrecorder.dao.QuestionnaireDao;
import com.lepton.surveyquestionrecorder.entity.dto.Questionnaire;
import com.lepton.surveyquestionrecorder.service.QuestionnaireCRUDService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
public class QuestionnaireCRUDServiceImpl implements QuestionnaireCRUDService {

    private final QuestionnaireDao questionnaireDao;

    public QuestionnaireCRUDServiceImpl(QuestionnaireDao questionnaireDao) {
        this.questionnaireDao = questionnaireDao;
    }

    @Override
    public void save(Questionnaire questionnaire) {
        questionnaireDao.save(questionnaire);
    }

    @Override
    public Questionnaire findById(Long id) {
        Optional<Questionnaire> questionnaire = questionnaireDao.findById(id);
        return questionnaire.orElse(null);
    }

    @Override
    public List<Questionnaire> findAll() {
        return questionnaireDao.findAll();
    }

    @Override
    public void delete(Long id) {
        questionnaireDao.deleteById(id);
    }

    @Override
    public List<Questionnaire> findByQuestionnaireName(String title) {
        return questionnaireDao.findByTitle(title);
    }

    @Override
    @Transactional
    public void editQuestionnaire(Questionnaire questionnaire) {
        questionnaireDao.delete(questionnaire);
        questionnaireDao.save(questionnaire);
    }


}
