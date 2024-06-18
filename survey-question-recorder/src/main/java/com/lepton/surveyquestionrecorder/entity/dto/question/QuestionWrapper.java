package com.lepton.surveyquestionrecorder.entity.dto.question;

import lombok.Data;

@Data
public class QuestionWrapper {

    private FRQ freeResponse;

    private MCQ multipleChoice;
}
