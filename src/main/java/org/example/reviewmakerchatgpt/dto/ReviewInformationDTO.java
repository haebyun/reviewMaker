package org.example.reviewmakerchatgpt.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReviewInformationDTO {
    private String gender;
    private String age;
    private String quality;
    private String costPerformance;
    private String length;
    private String category;
    private String subCategory;
    private String additionalText;
}
