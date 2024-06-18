package com.lepton.surveyquestionrecorder.entity.dto;


import com.lepton.surveyquestionrecorder.entity.dto.question.QuestionWrapper;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import java.util.List;


/*** This class defines a standard Questionnaire template
 * @author Charlie Wang
 * @version 0.0.1-SNAPSHOT
 */


@Data
@Document
public class Questionnaire {

    /**
     * Questionnaire Id
     */
    @Id
    private Long id;

    /**
     * Questionnaire created date
     */
    private String createdAt;

    /**
     * Questionnaire update date
     */
    private String updatedAt;

    /**
     * Questionnaire title
     */
    private String title;

    /**
     * Question Description
     */
    private String description;

    /**
     * Question collections
     */
    private List<QuestionWrapper> questions;

}
