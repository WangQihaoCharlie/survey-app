package com.lepton.surveyquestionrecorder.controller;


import com.lepton.surveycommon.utils.Result;
import com.lepton.surveyquestionrecorder.entity.dto.Questionnaire;
import com.lepton.surveyquestionrecorder.service.QuestionnaireCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recorder")
public class QuestionnaireController {


    private final QuestionnaireCRUDService questionnaireCRUDService;

    @Autowired
    public QuestionnaireController(QuestionnaireCRUDService questionnaireCRUDService) {
        this.questionnaireCRUDService = questionnaireCRUDService;
    }

    @PostMapping("/insert")
    public Result<String> insert(@RequestBody Questionnaire questionnaire) {
        questionnaireCRUDService.save(questionnaire);
        return new Result<String>().ok("Successfully inserted questionnaire");
    }

    @PostMapping("/delete")
    public Result<String> delete(@RequestParam Long questionnaireId) {
        questionnaireCRUDService.delete(questionnaireId);
        return new Result<String>().ok("Successfully deleted questionnaire");
    }

    @PostMapping("/edit")
    public Result<String> edit(@RequestBody Questionnaire questionnaire) {
        questionnaireCRUDService.editQuestionnaire(questionnaire);
        return new Result<String>().ok("Successfully edited questionnaire");
    }

    @PostMapping("/get-by-id")
    public Result<Questionnaire> getQuestionnaireById(@RequestParam Long id) {
        return new Result<Questionnaire>().ok(questionnaireCRUDService.findById(id));
    }

    @PostMapping("/get-by-title")
    public Result<List<Questionnaire>> getQuestionnaireByTitle(@RequestParam String title) {
        return new Result<List<Questionnaire>>().ok(questionnaireCRUDService.findByQuestionnaireName(title));
    }


}
