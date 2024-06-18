package com.lepton.surveyquestionrecorder.entity.dto.question;

import lombok.Data;

import java.util.List;

@Data
public class MCQ {
    /**
     * Question Id
     */
    private Long id;

    /**
     * Question content
     */
    private String question;

    /**
     * Number of Options
     */
    private Integer numOptions;

    /**
     * Options Text
     */
    private List<String> options;


}
