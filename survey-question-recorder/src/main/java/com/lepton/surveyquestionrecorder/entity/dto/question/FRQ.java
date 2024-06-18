package com.lepton.surveyquestionrecorder.entity.dto.question;

import lombok.Data;

@Data
public class FRQ{
    /**
     * Question Id
     */
    private Long id;

    /**
     * Question content
     */
    private String question;

    /**
     * Question Length Limit
     */
    private Integer lengthLimit;
}
